package com.hyundaimotors.hmb.cdppapp.payload.IFHMBDMSCDPP0004;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLeadContact {
    @JsonProperty("Nome")
    @Schema(description = "Contact Nome", example = "Carlos")
    private String nome;
    @JsonProperty("Sobrenome")
    @Schema(description = "Contact Sobrenome", example = "Cortez")
    private String sobrenome;
    @JsonProperty("Genero")
    @Schema(description = "Contact Gender", example = "Male")
    private String genero;
    @Schema(description = "YYYY-MM-DD", example = "21/10/1988")
    @JsonProperty("DataNascimento")
    private String dataNascimento;
    @Schema(description = "Contact Age", example = "26")
    @JsonProperty("Idade")
    private String idade;
    @Schema(description = "Contact Telefone", example = "11976588860")
    @JsonProperty("Telefone")
    private String telefone;
    @Schema(description = "Contact Email", example = "prueba@gmail.com")
    @JsonProperty("Email")
    private String email;
    @Schema(description = "Contact Cpf", example = "71238856724")
    @JsonProperty("Cpf")
    private String cpf;
    @Schema(description = "Contact Cep", example = "4007001")
    @JsonProperty("Cep")
    private String cep;
    @Schema(description = "Contact Endereco", example = "Rua Tutoia 879")
    @JsonProperty("Endereco")
    private String endereco;
    @Schema(description = "Contact IDConnex", example = "1-6789YU")
    @JsonProperty("IDSiebel")
    private String idconnex;
    @Schema(description = "YYYY-MM-DD hh24:mi:ss", example = "12/11/2017:12:00:00")
    @JsonProperty("DataPrevistaCarroNovo")
    private String dataPrevistaCarroNovo;
    @Schema(description = "", example = "")
    @JsonProperty("IP")
    private String ip;

}
