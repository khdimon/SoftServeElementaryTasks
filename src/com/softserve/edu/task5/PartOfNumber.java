package com.softserve.edu.task5;

/**
 * Represents part of number -
 * units, thousands, millions etc.
 */
public class PartOfNumber {
    /**
     * Radix of the number system that we consider.
     */
    private static final int RADIX = 10;


    /**
     * Maximum value of a part of number.
     */
    private static final int MAX_VALUE = 999;

    /**
     * Maximum index of a part of number.
     */
    public static final int MAX_INDEX = 11;

    /**
     * Number of digits of a part of number.
     */
    public static final int DIGITS_IN_PART = 3;

    public static final String[] UNITS_1 = {"", "один", "два", "три",
            "четыре", "пять", "шесть", "семь", "восемь", "девять"};

    public static final String[] UNITS_2 = {"", "одна", "две", "три",
            "четыре", "пять", "шесть", "семь", "восемь", "девять"};

    public static final String[] SECOND_TEN = {"десять", "одиннадцать",
            "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

    public static final String[] TENS = {"", "десять", "двадцать",
            "тридцать", "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят", "девяносто"};

    public static final String[] HUNDREDS = {"", "сто", "двести",
            "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
            "восемьсот", "девятьсот"};

    public static final String[] INDEXES_1 = {"", "тысяча", "миллион",
            "миллиард", "триллион", "квадриллион", "квинтиллион",
            "секстиллион", "септиллион", "октиллион", "нониллион",
            "дециллион"};

    public static final String[] INDEXES_2 = {"", "тысячи", "миллиона",
            "миллиарда", "триллиона", "квадриллиона", "квинтиллиона",
            "секстиллиона", "септиллиона", "октиллиона", "нониллиона",
            "дециллиона"};

    public static final String[] INDEXES_3 = {"", "тысяч", "миллионов",
            "миллиардов", "триллионов", "квадриллионов", "квинтиллионов",
            "секстиллионов", "септиллионов", "октиллионов", "нониллионов",
            "дециллионов"};

    /**
     * index of this part of number:
     * 0 - units, 1 - thousands, 2 - millions etc.
     * It can be from 0 to MAX_INDEX.
     */
    private int index;

    /**
     * Number that is contained in this part of number.
     * It can be from 0 to 999.
     */
    private int value;

    /**
     * Number of hundreds in value of this part of number.
     */
    private int hundreds;

    /**
     * Number of tens in value of this part of number.
     */
    private int tens;

    /**
     * Number of units in value of this part of number.
     */
    private int units;

    /**
     * Representation of this part of number in words
     * (Examples: "сто двадцать три тысячи",
     * "пятьсот сорок один миллион").
     */
    private String representation;

    /**
     * Constructs a new part of number.
     *
     * @param index index of this part of number:
     *              0 - units, 1 - thousands, 2 - millions etc.
     *              It can be from 0 to MAX_INDEX.
     * @param value Number that is contained in this part of number.
     *              It can be from 0 to 999.
     */
    public PartOfNumber(int index, int value) {
        if (index < 0 || index > MAX_INDEX || value < 0
                || value > MAX_VALUE) {
            throw new IllegalArgumentException("Wrong index or value");
        }

        this.index = index;
        this.value = value;

        if (value == 0) {
            representation = "";
            return;
        }

        hundreds = value / (RADIX * RADIX);
        tens = value / RADIX % RADIX;
        units = value % RADIX;
    }

    /**
     * Returns the value of this part of number in words
     * (Examples: "сто двадцать три",
     * "пятьсот сорок один").
     *
     * @return value of this part of number in words
     */
    private String getValueName() {
        //сто + одиннадцать, шестьсот + пятнадцать
        if (tens == 1) {
            return HUNDREDS[hundreds] + " " + SECOND_TEN[units];
        }

        //сто + двадцать + одна (тысяча), шестьсот + тридцать + две (тысячи)
        if (index == 1) {
            return HUNDREDS[hundreds] + " " + TENS[tens] + " " + UNITS_2[units];
        }

        //сто + двадцать + один (миллион), шестьсот + тридцать + два (миллиарда)
        return HUNDREDS[hundreds] + " " + TENS[tens] + " " + UNITS_1[units];
    }

    /**
     * Returns the index of this part of number in words
     * (Examples: "тысячи", "миллион").
     *
     * @return index of this part of number in words
     */
    private String getIndexName() {
        //(111) тысяч, (615) миллионов
        if (tens == 1) {
            return INDEXES_3[index];
        }

        //(121) тысяча, (631) миллион
        if (units == 1) {
            return INDEXES_1[index];
        }

        //(122) тысячи, 633 миллиона
        if (units == 2 || units == 3 || units == 4) {
            return INDEXES_2[index];
        }

        //125 тысяч, 636 миллионов
        return INDEXES_3[index];
    }

    /**
     * If representation of this part of number in words is absent
     * creates it as value in words + index in words.
     * Returns this representation.
     *
     * @return representation of this part of number in words
     */
    public String getRepresentation() {
        if (representation != null) {
            return representation;
        }

        representation = (getValueName() + " " + getIndexName())
                .replaceAll("\\s+", " ");
        return representation;
    }

    /**
     * Checks this PartOfNumber for equality to another object.
     *
     * @param o another object
     * @return the result of checking
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartOfNumber that = (PartOfNumber) o;

        if (index != that.index) return false;
        return value == that.value;
    }

    /**
     * Returns hash code of this object.
     *
     * @return hash code of this object
     */
    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + value;
        return result;
    }
}
