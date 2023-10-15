package br.com.jedas.migracaodados.step;

import br.com.jedas.migracaodados.dominio.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MigrarPessoaStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migrarPessoaStep(ItemReader<Pessoa> arquivPessoaReader,
                                 ItemWriter<Pessoa> bancoPessoaWriter) {
        return stepBuilderFactory
                .get("migrarPessoaStep")
                .<Pessoa, Pessoa>chunk(1)
                .reader(arquivPessoaReader)
                .writer(bancoPessoaWriter)
                .build();
    }
}
