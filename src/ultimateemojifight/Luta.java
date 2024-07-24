package ultimateemojifight;

import java.util.Objects;
import java.util.Random;

public class Luta {
    // Atributos
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovado;
    // Métodos Especiais
    private Lutador getDesafiado() {
        return desafiado;
    }

    private void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    private Lutador getDesafiante() {
        return desafiante;
    }

    private void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    private int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
    // Métodos Públicos
    public void marcarLuta(Lutador lutador1, Lutador lutador2) {
        if (Objects.equals(lutador1.getCategoria(), lutador2.getCategoria())
                && lutador1 != lutador2) {
            setAprovado(true);
            setDesafiado(lutador1);
            setDesafiante(lutador2);
        } else {
            setAprovado(false);
            setDesafiado(null);
            setDesafiante(null);
        }
    }

    public void lutar() {
        if (isAprovado()) {
            System.out.println("### DESAFIADO ###");
            desafiado.apresentar();
            System.out.println("### DESAFIANTE ###");
            desafiante.apresentar();
            Random random = new Random();
            int Vencedor = random.nextInt(0,3);
            System.out.println("============== RESULTADO DA LUTA =================");
            switch (Vencedor) {
                case 0:
                    System.out.println("Empatou!");
                    desafiado.empatarLuta();
                    desafiante.empatarLuta();
                break;
                case 1:
                    System.out.println("Vitória do " + desafiado.getNome());
                    desafiado.ganharLuta();
                    desafiante.perderLuta();
                break;
                case 2:
                    System.out.println("Vitória do " + desafiante.getNome());
                    desafiado.perderLuta();
                    desafiante.ganharLuta();
                break;
            }
            System.out.println("==================================================");
        } else {
            System.out.println("Luta não pode acontecer.");
        }
    }
}
