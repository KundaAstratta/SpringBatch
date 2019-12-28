package filrouge.training.batch.springbatchdemo.config;



import filrouge.training.batch.springbatchdemo.dto.CollaboratorDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;


import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;


import javax.sql.DataSource;


@Configuration
@EnableBatchProcessing
public class ImportJobConfig {


    private static final Logger LOGGER = LoggerFactory.getLogger(ImportJobConfig.class);

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean(name="importJob")
    public Job importBookJob(final Step importStep, final JobCompletionNotificationListener listener) {

        return jobBuilderFactory.get("import-job")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(importStep)
                .end()
                .build();
    }

    @Bean
    public Step importStep (final FlatFileItemReader<CollaboratorDTO> importReader,
        final ItemProcessor<CollaboratorDTO, CollaboratorDTO> importProcessor,
        final ItemWriter<CollaboratorDTO> importWriter) {
        return stepBuilderFactory.get("import-step")
                .<CollaboratorDTO, CollaboratorDTO>chunk(10)
                .reader(importReader)
                .processor(importProcessor())
                .writer(importWriter)
                .build();
    }


    @StepScope
    @Bean
    //    public FlatFileItemReader<BookDto> importReader(@Value("#{jobParameters['input-file']}") final String inputFile) {
    public FlatFileItemReader<CollaboratorDTO> importReader(@Value("src/main/resources/input-data.csv") final String inputFile) {

            return new FlatFileItemReaderBuilder<CollaboratorDTO>()
            .name("collaboratorItemReader")
            .resource(new FileSystemResource(inputFile))
            .delimited()
            .delimiter(";")
            .names(new String[] { "uid", "civilite", "nom", "prenom", "fonction", "telephone", "mail", "etage", "uoAffectation", "codeImmeubleEmplacementCollaborateur", "region", "codeRegion", "niveauTerritoire", "codeTerritoire", "niveauEntite", "codeEntite", "niveauAgence", "codeAgence", "localisationCollaborateur", "pj", "aMigrer"
            })
            .linesToSkip(1)
            .fieldSetMapper(new BeanWrapperFieldSetMapper<CollaboratorDTO>() {
                {
                    setTargetType(CollaboratorDTO.class);
                }
            }).build();

    }

    @Bean
    public ItemProcessor<CollaboratorDTO, CollaboratorDTO> importProcessor() {

        return new ItemProcessor<CollaboratorDTO, CollaboratorDTO>() {

            @Override
            public CollaboratorDTO process(final CollaboratorDTO collaborator) throws Exception {
                LOGGER.info("Processing {}", collaborator);
                return collaborator;
            }
        };
    }



    @Bean
    public JdbcBatchItemWriter<CollaboratorDTO> importWriter(final DataSource
                                                       dataSource) {

        return new JdbcBatchItemWriterBuilder<CollaboratorDTO>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
               .sql("INSERT INTO collaborateur (uid, civilite, nom, prenom, fonction, telephone, mail, etage, uo_affectation, code_immeuble_emplacement_collaborateur, region, code_region, niveau_territoire, code_territoire, niveau_entite, code_entite, niveau_agence, code_agence, localisation_collaborateur, pj, a_migrer, create_date_time, update_date_time) " +
                       "VALUES (:uid, :civilite, :nom, :prenom, :fonction, :telephone, :mail, :etage, :uoAffectation, :codeImmeubleEmplacementCollaborateur, :region, :codeRegion, :niveauTerritoire, :codeTerritoire, :niveauEntite, :codeEntite, :niveauAgence, :codeAgence, :localisationCollaborateur, :pj, :aMigrer, now(), now())")
                .dataSource(dataSource)
                .build();

    }
}