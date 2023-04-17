package br.com.sugestao.chef.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 
 * @author Thiago de Luca
 *
 */
@Table("receita")
public record Receita(@Id @Column("id") Long id,
					  @Column("ingredientes") String ingredientes,
					  @Column("sugestao") String sugestao) {}