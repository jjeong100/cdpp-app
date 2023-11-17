package com.hyundaimotors.hmb.cdppapp.payload.IFHMBINNOCEANCDPP0088;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmaroCSISurveyAnswer {
    @Schema(description = "Question unique identifier code.", example = "1365")
    @NotNull @NotBlank @NotEmpty
    private String questionId;
    @Schema(description = "Question numeric sequence in the survey.", example = "10")
    @NotNull @NotBlank @NotEmpty
    private String questionCode;
    @Schema(description = "Question description.", example = "Consta em nosso banco de dados que o(a) sr(a) adquiriu o veículo ##VEICULO##, na concessionária  ##FILIAL##. O(A) sr.(a) foi responsável e esteve presente pessoalmente durante as negociações de compra assim como no momento da retirada do veículo?")
    @NotNull @NotBlank @NotEmpty
    private String questionComments;
    @Schema(description = "Answer description.", example = "<Long>")
    private String answerDescription;
    @Schema(description = "Answer numeric weight value.", example = "100")
    private String answerValue;
    @Schema(description = "Answer complementary information.", example = "Outros (Verbalizar)")
    private String answerComplement;
}
