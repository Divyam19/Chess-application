import javax.swing.*;
import java.awt.*;

public class methods {
    Icon tempIcon;
    int  initialX;
    int  initialY;
    String name;

    void getTempIcon(JButton[][] button,int x,int y) {
        tempIcon = button[x][y].getIcon();
        initialX = x;
        initialY = y;
        name = button[x][y].getName();
    }
    Icon setTempIcon(){
        return tempIcon;
    }
    int setInitailX(){
        return initialX;
    }
    int setInitialY(){
        return initialY;
    }
    void colorReset(JButton[][] button){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                button[i][j].setBackground(Color.getHSBColor(216.75F, 221.85F,119.85F));
                if (i % 2 == j % 2)
                    button[i][j].setBackground(Color.white);
            }
        }

    }
    void setGreenForWhite(JButton[][] button,int x,int y) {
        if (button[x][y].getName() == "white") {
        }
        else if(button[x][y].getName()=="black"){
            button[x][y].setBackground(Color.RED);
        }
        else
            button[x][y].setBackground(Color.green);
    }
    void setGreenForBlack(JButton[][] button,int x,int y) {
        if (button[x][y].getName() == "black") {
        }
        else if(button[x][y].getName()=="white"){
            button[x][y].setBackground(Color.RED);
        }
        else
            button[x][y].setBackground(Color.green);
    }

    void move(JButton[][] button,int x,int y){
        button[initialX][initialY].setIcon(null);
        button[x][y].setIcon(tempIcon);
        button[x][y].setName(button[initialX][initialY].getName());
        button[initialX][initialY].setName(null);
        colorReset(button);
    }

    void WQueen(JButton[][] button, int x, int y) {
        colorReset(button);
        getTempIcon(button,x,y);
        try {
            for (int i = x + 1; i < 8; i++) {
                if (button[i][y + (i - x)].getName() == null) {
                    setGreenForWhite(button, i, y + (i - x));
                } else if (button[i][y + (i - x)].getName() == "white")
                    break;

                else if (button[i][y + (i - x)].getName() == "black") {
                    setGreenForWhite(button, i, y + (i - x));
                    break;
                }

            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}
        try{
            for(int i=x-1;i>=0;i--){
                if(button[i][y-(x-i)].getName()==null) {
                    setGreenForWhite(button, i, y-(x-i));
                }
                else if(button[i][y-(x-i)].getName()=="white")
                    break;

                else if(button[i][y-(x-i)].getName()=="black"){
                    setGreenForWhite(button,i,y-(x-i));
                    break;
                }

            }
        }

        catch (ArrayIndexOutOfBoundsException exx){}
        try {
            for (int i = y - 1; i >= 0; i--) {
                if (button[x + (y-i)][i].getName() == null) {
                    setGreenForWhite(button, x + (y-i), i);
                } else if (button[x + (y-i)][i].getName() == "white")
                    break;

                else if (button[x + (y-i)][i].getName() == "black") {
                    setGreenForWhite(button, x + (y-i), i);
                    break;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}

        try {
            for (int i = y + 1; i < 8; i++) {
                if (button[x - (i-y)][i].getName() == null) {
                    setGreenForWhite(button, x - (i-y), i);
                } else if (button[x - (i-y)][i].getName() == "white")
                    break;

                else if (button[x - (i-y)][i].getName() == "black") {
                    setGreenForWhite(button, x - (i-y), i);
                    break;
                }

            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}

        for(int i=x+1;i<8;i++){
            if(button[i][y].getName()==null) {
                setGreenForWhite(button, i, y);
            }
            else if(button[i][y].getName()=="white")
                break;

            else if(button[i][y].getName()=="black"){
                setGreenForWhite(button,i,y);
                break;
            }

        }
        for(int i=x-1;i>=0;i--){
            if(button[i][y].getName()==null) {
                setGreenForWhite(button, i, y);
            }
            else if(button[i][y].getName()=="white")
                break;
            else if(button[i][y].getName()=="black"){
                setGreenForWhite(button,i,y);
                break;
            }

        }
        for(int i=y+1;i<8;i++){
            if(button[x][i].getName()==null) {
                setGreenForWhite(button, x, i);
            }
            else if(button[x][i].getName()=="white")
                break;
            else if(button[x][i].getName()=="black"){
                setGreenForWhite(button,x,i);
                break;
            }

        }
        for(int i=y-1;i>=0;i--){
            if(button[x][i].getName()==null) {
                setGreenForWhite(button, x, i);
            }
            else if(button[x][i].getName()=="white")
                break;
            else if(button[x][i].getName()=="black"){
                setGreenForWhite(button,x,i);
                break;
            }

        }
    }
    void BQueen(JButton[][] button, int x,int y){
        colorReset(button);
        getTempIcon(button,x,y);
        try{
            setGreenForBlack(button,x-1,y);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x-1,y+1);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x,y+1);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x+1,y+1);
        }
        catch (Exception e){}

        try{
            setGreenForBlack(button,x+1,y);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x,y-1);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x+1,y-1);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x-1,y-1);
        }
        catch (Exception e){}

        try {
            for (int i = x + 1; i < 8; i++) {
                if (button[i][y + (i - x)].getName() == null) {
                    setGreenForBlack(button, i, y + (i - x));
                } else if (button[i][y + (i - x)].getName() == "black")
                    break;

                else if (button[i][y + (i - x)].getName() == "white") {
                    setGreenForBlack(button, i, y + (i - x));
                    break;
                }

            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}
        try{
            for(int i=x-1;i>=0;i--){
                if(button[i][y-(x-i)].getName()==null) {
                    setGreenForBlack(button, i, y-(x-i));
                }
                else if(button[i][y-(x-i)].getName()=="black")
                    break;

                else if(button[i][y-(x-i)].getName()=="white"){
                    setGreenForBlack(button,i,y-(x-i));
                    break;
                }

            }
        }

        catch (ArrayIndexOutOfBoundsException exx){}
        try {
            for (int i = y - 1; i >= 0; i--) {
                if (button[x + (y-i)][i].getName() == null) {
                    setGreenForBlack(button, x + (y-i), i);
                } else if (button[x + (y-i)][i].getName() == "black")
                    break;

                else if (button[x + (y-i)][i].getName() == "white") {
                    setGreenForBlack(button, x + (y-i), i);
                    break;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}

        try {
            for (int i = y + 1; i < 8; i++) {
                if (button[x - (i-y)][i].getName() == null) {
                    setGreenForBlack(button, x - (i-y), i);
                } else if (button[x - (i-y)][i].getName() == "black")
                    break;

                else if (button[x - (i-y)][i].getName() == "white") {
                    setGreenForBlack(button, x - (i-y), i);
                    break;
                }

            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}

        for(int i=x+1;i<8;i++){
            if(button[i][y].getName()==null) {
                setGreenForBlack(button, i, y);
            }
            else if(button[i][y].getName()=="black")
                break;

            else if(button[i][y].getName()=="white"){
                setGreenForBlack(button,i,y);
                break;
            }

        }
        for(int i=x-1;i>=0;i--){
            if(button[i][y].getName()==null) {
                setGreenForBlack(button, i, y);
            }
            else if(button[i][y].getName()=="black")
                break;
            else if(button[i][y].getName()=="white"){
                setGreenForBlack(button,i,y);
                break;
            }

        }
        for(int i=y+1;i<8;i++){
            if(button[x][i].getName()==null) {
                setGreenForBlack(button, x, i);
            }
            else if(button[x][i].getName()=="black")
                break;
            else if(button[x][i].getName()=="white"){
                setGreenForBlack(button,x,i);
                break;
            }

        }
        for(int i=y-1;i>=0;i--){
            if(button[x][i].getName()==null) {
                setGreenForBlack(button, x, i);
            }
            else if(button[x][i].getName()=="black")
                break;
            else if(button[x][i].getName()=="white"){
                setGreenForBlack(button,x,i);
                break;
            }

        }
    }

    void BKing(JButton[][] button, int x, int y) {
        colorReset(button);
        getTempIcon(button,x,y);
        try{
            setGreenForBlack(button,x-1,y);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x-1,y+1);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x,y+1);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x+1,y+1);
        }
        catch (Exception e){}

        try{
            setGreenForBlack(button,x+1,y);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x,y-1);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x+1,y-1);
        }
        catch (Exception e){}
        try{
            setGreenForBlack(button,x-1,y-1);
        }
        catch (Exception e){}
    }
    void WKing(JButton[][] button, int x, int y) {
        colorReset(button);
        getTempIcon(button,x,y);
        try{
            setGreenForWhite(button,x-1,y);
        }
        catch (Exception e){}
        try{
            setGreenForWhite(button,x-1,y+1);
        }
        catch (Exception e){}
        try{
            setGreenForWhite(button,x,y+1);
        }
        catch (Exception e){}
        try{
            setGreenForWhite(button,x+1,y+1);
        }
        catch (Exception e){}

        try{
            setGreenForWhite(button,x+1,y);
        }
        catch (Exception e){}
        try{
            setGreenForWhite(button,x,y-1);
        }
        catch (Exception e){}
        try{
            setGreenForWhite(button,x+1,y-1);
        }
        catch (Exception e){}
        try{
            setGreenForWhite(button,x-1,y-1);
        }
        catch (Exception e){}
    }


    void WBishop(JButton[][] button, int x, int y) {
        colorReset(button);
        getTempIcon(button,x,y);
        try {
            for (int i = x + 1; i < 8; i++) {
                if (button[i][y + (i - x)].getName() == null) {
                    setGreenForWhite(button, i, y + (i - x));
                } else if (button[i][y + (i - x)].getName() == "white")
                    break;

                else if (button[i][y + (i - x)].getName() == "black") {
                    setGreenForWhite(button, i, y + (i - x));
                    break;
                }

            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}
        try{
            for(int i=x-1;i>=0;i--){
                if(button[i][y-(x-i)].getName()==null) {
                    setGreenForWhite(button, i, y-(x-i));
                }
                else if(button[i][y-(x-i)].getName()=="white")
                    break;

                else if(button[i][y-(x-i)].getName()=="black"){
                    setGreenForWhite(button,i,y-(x-i));
                    break;
            }

            }
        }

        catch (ArrayIndexOutOfBoundsException exx){}
        try {
            for (int i = y - 1; i >= 0; i--) {
                if (button[x + (y-i)][i].getName() == null) {
                    setGreenForWhite(button, x + (y-i), i);
                } else if (button[x + (y-i)][i].getName() == "white")
                    break;

                else if (button[x + (y-i)][i].getName() == "black") {
                    setGreenForWhite(button, x + (y-i), i);
                    break;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}

        try {
            for (int i = y + 1; i < 8; i++) {
                if (button[x - (i-y)][i].getName() == null) {
                    setGreenForWhite(button, x - (i-y), i);
                } else if (button[x - (i-y)][i].getName() == "white")
                    break;

                else if (button[x - (i-y)][i].getName() == "black") {
                    setGreenForWhite(button, x - (i-y), i);
                    break;
                }

            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}
    }
    void BBishop(JButton[][] button, int x, int y) {
        colorReset(button);
        getTempIcon(button,x,y);
        try {
            for (int i = x + 1; i < 8; i++) {
                if (button[i][y + (i - x)].getName() == null) {
                    setGreenForBlack(button, i, y + (i - x));
                } else if (button[i][y + (i - x)].getName() == "black")
                    break;

                else if (button[i][y + (i - x)].getName() == "white") {
                    setGreenForBlack(button, i, y + (i - x));
                    break;
                }

            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}
        try{
            for(int i=x-1;i>=0;i--){
                if(button[i][y-(x-i)].getName()==null) {
                    setGreenForBlack(button, i, y-(x-i));
                }
                else if(button[i][y-(x-i)].getName()=="black")
                    break;

                else if(button[i][y-(x-i)].getName()=="white"){
                    setGreenForBlack(button,i,y-(x-i));
                    break;
                }

            }
        }

        catch (ArrayIndexOutOfBoundsException exx){}
        try {
            for (int i = y - 1; i >= 0; i--) {
                if (button[x + (y-i)][i].getName() == null) {
                    setGreenForBlack(button, x + (y-i), i);
                } else if (button[x + (y-i)][i].getName() == "black")
                    break;

                else if (button[x + (y-i)][i].getName() == "white") {
                    setGreenForBlack(button, x + (y-i), i);
                    break;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}

        try {
            for (int i = y + 1; i < 8; i++) {
                if (button[x - (i-y)][i].getName() == null) {
                    setGreenForBlack(button, x - (i-y), i);
                } else if (button[x - (i-y)][i].getName() == "black")
                    break;

                else if (button[x - (i-y)][i].getName() == "white") {
                    setGreenForBlack(button, x - (i-y), i);
                    break;
                }

            }
        }
        catch (ArrayIndexOutOfBoundsException exx){}
    }


    void Wpawn(int x, int y, JButton[][] button) {
        colorReset(button);
        getTempIcon(button,x,y);
        if(x==1&&button[x+1][y].getIcon()==null){
            if(button[x+2][y].getIcon()==null) {
                setGreenForWhite(button, x+2, y);
            }
            if(button[x+1][y].getIcon()==null) {
                setGreenForWhite(button,x+1,y);
            }
            try {
                if (button[x + 1][y - 1].getIcon() != null)
                    setGreenForWhite(button,x+1,y-1);
                if (button[x + 1][y + 1].getIcon() != null)
                    setGreenForWhite(button,x+1,y+1);
            }
            catch(ArrayIndexOutOfBoundsException exx){}
        }
        else{
            if(button[x+1][y].getIcon()==null) {
                setGreenForWhite(button,x+1,y);
            }
            try {
                if (button[x + 1][y - 1].getIcon() != null)
                    setGreenForWhite(button,x+1,y-1);
                if (button[x + 1][y + 1].getIcon() != null)
                    setGreenForWhite(button,x+1,y+1);
            }
            catch(ArrayIndexOutOfBoundsException exx){}
        }
    }
    void Bpawn(int x, int y, JButton[][] button) {
        colorReset(button);
        getTempIcon(button, x, y);
        if (x == 6&&button[x-1][y].getIcon()==null) {
            if (button[x - 2][y].getIcon() == null) {
                setGreenForBlack(button, x - 2, y);
            }
            if (button[x - 1][y].getIcon() == null) {
                setGreenForBlack(button, x - 1, y);
            }
            try {
                if (button[x - 1][y + 1].getIcon() != null)
                    setGreenForBlack(button, x - 1, y + 1);
                if (button[x - 1][y - 1].getIcon() != null)
                    setGreenForBlack(button, x - 1, y - 1);
            } catch (ArrayIndexOutOfBoundsException exx) {
            }

        } else {
            if (button[x - 1][y].getIcon() == null) {
                setGreenForBlack(button, x - 1, y);
            }
            try {
                if (button[x - 1][y + 1].getIcon() != null)
                    setGreenForBlack(button, x - 1, y + 1);
                if (button[x - 1][y - 1].getIcon() != null)
                    setGreenForBlack(button, x - 1, y - 1);
            } catch (ArrayIndexOutOfBoundsException exx) {
            }

        }
    }


    void WRook(JButton[][] button, int x, int y) {
        colorReset(button);
        getTempIcon(button, x, y);

        for(int i=x+1;i<8;i++){
            if(button[i][y].getName()==null) {
                setGreenForWhite(button, i, y);
            }
            else if(button[i][y].getName()=="white")
                break;

            else if(button[i][y].getName()=="black"){
                setGreenForWhite(button,i,y);
                break;
            }

        }
        for(int i=x-1;i>=0;i--){
            if(button[i][y].getName()==null) {
                setGreenForWhite(button, i, y);
            }
            else if(button[i][y].getName()=="white")
                break;
            else if(button[i][y].getName()=="black"){
                setGreenForWhite(button,i,y);
                break;
            }

        }
        for(int i=y+1;i<8;i++){
            if(button[x][i].getName()==null) {
                setGreenForWhite(button, x, i);
            }
            else if(button[x][i].getName()=="white")
                break;
            else if(button[x][i].getName()=="black"){
                setGreenForWhite(button,x,i);
                break;
            }

        }
        for(int i=y-1;i>=0;i--){
            if(button[x][i].getName()==null) {
                setGreenForWhite(button, x, i);
            }
            else if(button[x][i].getName()=="white")
                break;
            else if(button[x][i].getName()=="black"){
                setGreenForWhite(button,x,i);
                break;
            }

        }
    }
    void BRook(JButton[][] button, int x, int y) {
        colorReset(button);
        getTempIcon(button, x, y);

        for(int i=x+1;i<8;i++){
            if(button[i][y].getName()==null) {
                setGreenForBlack(button, i, y);
            }
            else if(button[i][y].getName()=="black")
                break;

            else if(button[i][y].getName()=="white"){
                setGreenForBlack(button,i,y);
                break;
            }

        }
        for(int i=x-1;i>=0;i--){
            if(button[i][y].getName()==null) {
                setGreenForBlack(button, i, y);
            }
            else if(button[i][y].getName()=="black")
                break;
            else if(button[i][y].getName()=="white"){
                setGreenForBlack(button,i,y);
                break;
            }

        }
        for(int i=y+1;i<8;i++){
            if(button[x][i].getName()==null) {
                setGreenForBlack(button, x, i);
            }
            else if(button[x][i].getName()=="black")
                break;
            else if(button[x][i].getName()=="white"){
                setGreenForBlack(button,x,i);
                break;
            }

        }
        for(int i=y-1;i>=0;i--){
            if(button[x][i].getName()==null) {
                setGreenForBlack(button, x, i);
            }
            else if(button[x][i].getName()=="black")
                break;
            else if(button[x][i].getName()=="white"){
                setGreenForBlack(button,x,i);
                break;
            }

        }
    }

    void WHorse(JButton[][] button, int x, int y) {
        colorReset(button);
        getTempIcon(button,x,y);
        try {
            setGreenForWhite(button, x - 2, y + 1);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForWhite(button, x - 2, y - 1);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForWhite(button, x + 2, y - 1);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try{
            setGreenForWhite(button, x + 2, y + 1);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForWhite(button, x - 1, y -2);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForWhite(button, x +1, y +2);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForWhite(button, x -1, y +2);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try{
            setGreenForWhite(button, x +1, y -2);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
    }
    void BHorse(JButton[][] button, int x, int y) {
        colorReset(button);
        getTempIcon(button,x,y);
        try {
            setGreenForBlack(button, x - 2, y + 1);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForBlack(button, x - 2, y - 1);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForBlack(button, x + 2, y - 1);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try{
            setGreenForBlack(button, x + 2, y + 1);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForBlack(button, x - 1, y -2);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForBlack(button, x +1, y +2);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try {
            setGreenForBlack(button, x -1, y +2);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
        try{
            setGreenForBlack(button, x +1, y -2);
        }
        catch(ArrayIndexOutOfBoundsException exxx){}
    }



}
