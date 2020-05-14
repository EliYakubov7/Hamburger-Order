package hit.gever.myhamburgerorder;

public class Hamburger {

    private double hamburger_size_price;
    private double fried_egg_price = 0;
    private double fried_onion_price = 0;
    private double chili_pineapple_price = 0;

    public Hamburger()
    {

    }

    public double getHamburger_size_price() {
        return hamburger_size_price;
    }

    public void setHamburger_size_price(double hamburger_size_price) {
        this.hamburger_size_price = hamburger_size_price;
    }

    public double getFried_egg_price() {
        return fried_egg_price;
    }

    public void setFried_egg_price(double fried_egg_price) {
        this.fried_egg_price = fried_egg_price;
    }

    public double getFried_onion_price() {
        return fried_onion_price;
    }

    public void setFried_onion_price(double fried_onion_price) {
        this.fried_onion_price = fried_onion_price;
    }

    public double getChili_pineapple_price() {
        return chili_pineapple_price;
    }

    public void setChili_pineapple_price(double chili_pineapple_price) {
        this.chili_pineapple_price = chili_pineapple_price;
    }
}
