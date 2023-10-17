package br.com.jedas.migracaodados.writer;

import br.com.jedas.migracaodados.dominio.DadosBancarios;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BancoDadosBancariosWriterConfig {
    @Bean
    public JdbcBatchItemWriter<DadosBancarios> bancoDadosBancarioWriter(@Qualifier("appDataSource") DataSource dataSource){
        return new JdbcBatchItemWriterBuilder()
                .dataSource(dataSource)
                .sql("INSERT INTO DADOS_BANCARIOS (id, pessoa_id, agencia, conta, banco) values (:id,:pessoaId,:agencia,:conta,:banco)")
                .beanMapped()
                .build();
    }


}
