package no.hvl.dat100.javel.oppgave1;

/*En klasse som brukes for å beregne strømpriser for en dag(Typisk kwh for 24-timer og strømprisene for 24 timer).
 Knyttes opp mot Månedlig strøm-og-pris beregning.*/
public class DailyPower {

    // a) print power prices during a day
    //Bruker for-løkke for å gå igjennom listen prices, og printe ut kr-prisen per kwh fra hvert enkelt element i listen
    public static void printPowerPrices(double[] prices) {

        for(int i = 0; i < prices.length; i++){
            System.out.printf("%.2f NOK ", prices[i]);
        }
    }

    // b) print power usage during a day
    //Bruker for-løkke for å gå igjennom listen usage, og printe ut kwh fra hvert enkelt element i listen
    public static void printPowerUsage(double[] usage) {
        for(int i = 0; i < usage.length; i++){
            System.out.printf("%.2f kwh ", usage[i]);
        }
    }

    // c) compute power usage for a single day
    //Bruker for-løkke for å gå igjennom listen usage, summere alle elementene(Kwh) i listen og returnere summen
    public static double computePowerUsage(double[] usage) {
        double sum = 0;

        for(int i = 0; i < usage.length; i++){
            sum += usage[i];
        }
        return sum;
    }

    // d) compute spot price for a single day
    /*Man må gå utifra at pris og forbruk har lik tabbellstørrelse, og spotpris skal beregnes på samme
         index på begge tabellene. Det gjør at man bare trenger en for-løkke.
        Spot-pris beregnes ved å multiplisere forbruket for den timen med kw-prisen for den timen.
        Dette gjøres for de 24 timene i døgnet. Returnerer pris*/
    public static double computeSpotPrice(double[] usage, double[] prices) {

        double price = 0;

        for(int i = 0; i < usage.length; i++){
            price += prices[i] * usage[i];
        }

        return price;
    }

    // e) compute power support for a given usage and price
    //Om prisen per kilowatt går over 0.9375 kroner(THRESHOLD) får man 90% avslag(PERCENTAGE) på prisen over grensen.
    private static final double THRESHOLD = 0.9375;
    private static final double PERCENTAGE = 0.9;

    //Sjekk om prisen er over grenseverdi(THRESHOLD) på en av timene i døgnet, hvis ja, beregn støtte(90% avslag(PERCENTAGE) på prisen over grenseverdi) for den timen.
    private static double getSupport(double usage, double price) {

        double support = 0;

        if(price > THRESHOLD){
            support += (usage * (price-THRESHOLD))*PERCENTAGE; //Beregner pris pr kw på alt over 0.9375kroner(Grunnpris)
        }
        return support;
    }

    // f) compute power support for a single day
    //Man må gå utifra at pris og forbruk har lik tabbellstørrelse, og spotpris skal beregnes på samme
    // index på begge tabellene. Det gjør at man bare trenger en for-løkke.
    //Beregner power-support ved å summere alle tilfeller hvor bruke getSupport-metoden til å beregn
    public static double computePowerSupport(double[] usage, double[] prices) {

        double support = 0;
        for(int i = 0; i < usage.length; i++){
            support += getSupport(usage[i], prices[i]);

        }
        return support;
    }

    private static final double NORGESPRIS_KWH = 0.5;//Prisen per kilowatth

    // g) compute norges pris for a single day
    //Rett frem kwh-pris-beregning. 0.5*forbruk per time. Bruker en for-løkke til å itterere gjennom listen slik at man summerer opp total forbrukspris for ett døgn.
    public static double computeNorgesPrice(double[] usage) {

        double price = 0;
        for(int i = 0; i < usage.length; i++){
            price += NORGESPRIS_KWH * usage[i];
        }
        return price;
    }

    // g) compute peak usage during a single day
    //Finn den timen i døgnet når forbruket var størst.
    public static double findPeakUsage(double[] usage) {

        double temp_max = usage[0];

        for(int i = 1; i < usage.length; i++){
            if(temp_max < usage[i])
            temp_max = usage[i];
        }
        return temp_max;
    }

    //Finn gjennomsnitts-strømforbruk ved å itterere igjennom usage-listen, summere opp forbruket og dele på antall elementer i listen.
    public static double findAvgPower(double[] usage) {

        double average = 0;

        for(int i = 0; i < usage.length; i++){
            average += usage[i];
        }
        return average/usage.length;
    }
}