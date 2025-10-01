package joc;

public class Jugades {
    public static boolean jugaNumero(int numEscollit, int result){
        return numEscollit==result;
    }

    public static boolean jugaColor(Color colorEscollit, Color colorResult){
        return colorEscollit == colorResult;
    }

    public static int jugaParell(int numCasella){
        int parells=0;

        if (numCasella!=0){
            for (int i = 1 ; i <= 36; i++){
                if (numCasella%2==0){
                    parells = 2;
                    return parells;
                }
                if (numCasella%2!=0){
                    parells = 1;
                    return parells;
                }
            }
        }

        return parells;
    }

    private Jugades(){}
}
