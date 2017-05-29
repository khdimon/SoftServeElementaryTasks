package com.softserve.edu.task5;

/**
 * Represents part of number -
 * units, thousands, millions etc.
 */
public class PartOfNumber {
    public static final int MAX_INDEX = 12;
    public static final int DIGITS_IN_PART = 3;
    public static final int RADIX = 10;

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
                || value > RADIX * RADIX * RADIX - 1) {
            throw new IllegalArgumentException("Wrong index or value");
        }

        if (value == 0) {
            representation = "";
            return;
        }

        int hundreds = value / (RADIX * RADIX);
        int tens = value / RADIX % RADIX;
        int units = value % RADIX;

        String numberName = "";
        String indexName = "";

        if (tens != 1) {
            String stringUnits = index == 1 ? UNITS_2[units] : UNITS_1[units];
            numberName = HUNDREDS[hundreds] + " " + TENS[tens]
                    + " " + stringUnits;

            if (units == 0 || units == 5 || units == 6 || units == 7
                    || units == 8 || units == 9) {
                indexName = INDEXES_3[index];
            }

            if (units == 2 || units == 3 || units == 4) {
                indexName = INDEXES_2[index];
            }

            if (units == 1) {
                indexName = INDEXES_1[index];
            }
        } else {
            numberName = HUNDREDS[hundreds] + " " + SECOND_TEN[units];
            indexName = INDEXES_3[index];
        }

        representation = numberName + " " + indexName;
    }

    /**
     * Returns representation of this part of number in words.
     *
     * @return representation of this part of number in words
     */
    @Override
    public String toString() {
        return representation;
    }
}
