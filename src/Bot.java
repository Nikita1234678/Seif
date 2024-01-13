import DataModel.TurnResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Bot {
    private List<Number[]> _variants;
    private Number[] _currentTurn;

    public Bot(){
        _variants =new ArrayList<>();
        _currentTurn =null;
    }

    public void InitGameStart() {
        for(int digit1 = 0 ; digit1 < 10; digit1++){
            for(int digit2 = 0 ; digit2 < 10; digit2++){
                if(digit1 == digit2){continue;}
                for(int digit3 = 0 ; digit3 < 10; digit3++){
                    if(digit3==digit1 || digit3==digit2){continue;}
                    for(int digit4 = 0 ; digit4 < 10; digit4++){
                        if(digit4==digit1 || digit4==digit2 || digit4==digit3){continue;}
                        Number[] variant = new Number[]{digit1, digit2, digit3, digit4};
                        _variants.add(variant);
                    }
                }
            }
        }
    }
    public String getTurn( ){
        Random generator = new Random();
        int turnIndex = generator.nextInt(_variants.size());
        _currentTurn = _variants.get(turnIndex);
        return Utilites.TurnArrayToString(_currentTurn);
    }
    public void setTurnResult(TurnResult result) {
        _variants = _variants.stream().filter(x->Utilites.getRightCounter(_currentTurn, x) == result.CorrectDigits).toList();
        _variants = _variants.stream().filter(x->Utilites.getInPlaceCount(_currentTurn, x) == result.DigitsInPlace).toList();
    }
}
