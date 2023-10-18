package br.com.jedas.migracaodados.step;

import br.com.jedas.migracaodados.dominio.DadosBancarios;
import br.com.jedas.migracaodados.dominio.Pessoa;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigrarDadosBancariosStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step migrarDadosBancariosStep(ItemReader<DadosBancarios> dadosBancariosItemReader,
                                 ItemWriter<DadosBancarios> dadosBancariosItemWriter) {
        return stepBuilderFactory
                .get("migrarDadosBancariosStep")
                .<DadosBancarios, DadosBancarios>chunk(10000)
                .reader(dadosBancariosItemReader)
                .writer(dadosBancariosItemWriter)
                .build();
    }
}
