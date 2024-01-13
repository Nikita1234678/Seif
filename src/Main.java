import DataModel.TurnResult;


import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
       Game game = new Game();
       Bot bot = new Bot();
       bot.InitGameStart();

       TheBestBot1Turn bested = new TheBestBot1Turn();

       String secret = game.getSecret();
      
       System.out.println("secret = "+ secret);
//       System.out.println("Vashe chislo");
//       bested.TheBestTurn(secret);

       NormalyBotMaybe normPocan = new NormalyBotMaybe();
       normPocan.createList();


        TurnResult result = null;
        int turnhod = 0;
        while ( result == null || result.DigitsInPlace < 4){
            System.out.println("Vashe chislo");
            String turn = normPocan.getTurn();
            result = game.Turn(turn);
            System.out.println("Bot turn - "+ turn);
            normPocan.setTurnResult(result);
            turnhod++;

            System.out.println("Sovpadenii:"+ result.CorrectDigits +"      Na meste: "+ result.DigitsInPlace+"      hod № "+turnhod );
        }
        System.out.println("You won");

    }
}

//        TurnResult result = null;
//        int turnhod = 0;
//        while ( result == null || result.DigitsInPlace < 4){
//            System.out.println("Vashe chislo");
//            String turn = bot.getTurn(turnhod);
//            result = game.Turn(turn);
//            System.out.println("Bot turn - "+ turn);
//            bot.setTurnResult(result);
//            turnhod++;
//
//            System.out.println("Sovpadenii:"+ result.CorrectDigits +"      Na meste: "+ result.DigitsInPlace+"      hod № "+turnhod );
//        }
//        System.out.println("You won");