package appstart.models;


public class ShoppingResponse {
    private boolean shoppingSuccess;
    private Integer lives;
    private Integer gold;
    private Integer level;
    private Integer turn;

    public boolean isShoppingSuccess() {
        return shoppingSuccess;
    }

    public void setShoppingSuccess(boolean shoppingSuccess) {
        this.shoppingSuccess = shoppingSuccess;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }
}
