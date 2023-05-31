package models;

import java.util.Map;

public class GrauPrioridade {
    public final static Map<Integer,String> grausPrioridade = Map.of(
        1, "Baixa",
        2, "Média",
        3, "Alta"
    );

    public static Map<Integer,String> getGrausPrioridade() {
        return grausPrioridade;
    }

    private String grauPrioridade;

    public GrauPrioridade(int grauPrioridade) {
        this.grauPrioridade = grausPrioridade.get(grauPrioridade);
    } 

    public String getGrauPrioridade() {
        return grauPrioridade;
    }
    
      
}
