package joc;

public class Jugades {
    public static boolean jugaNumero(int numEscollit, int result){
        return numEscollit==result;
    }

    public static boolean jugaColor(Color colorEscollit, Color colorResult){
        return colorEscollit == colorResult;
    }

    public static int jugaParell(int numCasella){
        if (numCasella!=0){
            if (numCasella % 2 == 0) {
                return 2;
            }
            return 1;
        }

        return 0;
    }

    private Jugades(){}
}
