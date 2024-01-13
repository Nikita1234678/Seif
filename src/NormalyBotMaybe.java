import DataModel.TurnResult;

import java.util.ArrayList;
import java.util.List;

public class NormalyBotMaybe {
    private List<Number[]> _fullSpisok;
    private Number[] _botTurn;
    Boolean trueFalse = true;

    public NormalyBotMaybe(){
        _fullSpisok=new ArrayList<>();
        _botTurn=null;
    }

    public void createList(){
        for(int digit1 = 0 ; digit1 < 10; digit1++){
            for(int digit2 = 0 ; digit2 < 10; digit2++){
                if(digit1 == digit2){continue;}
                for(int digit3 = 0 ; digit3 < 10; digit3++){
                    if(digit3==digit1 || digit3==digit2){continue;}
                    for(int digit4 = 0 ; digit4 < 10; digit4++){
                        if(digit4==digit1 || digit4==digit2 || digit4==digit3){continue;}
                        Number[] variant = new Number[]{digit1, digit2, digit3, digit4};
                        _fullSpisok.add(variant);
                    }
                }
            }
        }
    }

    public String getTurn(){
        if(trueFalse){
            trueFalse=false;
            _botTurn = _fullSpisok.get(0);
            return Utilites.TurnArrayToString(_botTurn);
        }
        trueFalse=true;
        _botTurn = _fullSpisok.get(_fullSpisok.size()-1);
        return Utilites.TurnArrayToString(_botTurn);
    }

    public void setTurnResult(TurnResult result) {
        _fullSpisok = _fullSpisok.stream().filter(x->Utilites.getRightCounter(_botTurn, x) == result.CorrectDigits).filter(x->Utilites.getInPlaceCount(_botTurn, x) == result.DigitsInPlace).toList();
    }
}
