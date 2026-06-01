package for_each.atividade;

public class atv_notas {
    static void main(String[] args) {

        Double[] notas = new Double[]{ 8.5, 6.0, 7.5, 5.0, 9.0 };
        double sum = 0.0;
        int approved = 0;

        for(Double obj : notas) {
            sum += obj;
            if(obj  >= 7.0) {
                approved++;
            }
        }
        double gradeAVG = sum / notas.length;;

        System.out.println(sum);
        System.out.println(gradeAVG);
        System.out.println(approved);
    }
}
