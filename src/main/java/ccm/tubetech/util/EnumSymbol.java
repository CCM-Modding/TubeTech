package ccm.tubetech.util;

import net.minecraft.util.ResourceLocation;

public enum EnumSymbol
{
    EXCLAMATION('!'),
    POUND('#'),
    DOLLAR('$'),
    PERCENT('%'),
    AND('&'),
    COMMA(','),
    SQUOTE('\''),
    DQUOTE('"'),
    DASH('-'),
    COLEN(':'), SEMICOLEN(';'),
    AT('@'),
    R_L_BRACKET('('), R_R_BRACKET(')'),
    S_L_BRACKET('['), S_R_BRACKET(']'),
    POWER('^'),
    UNDERSCORE('_'),
    P_L_BRACKET('{'), P_R_BRACKET('}'),
    TILDA('~'),
    PLUS('+'),
    EQUALS('='),
    ZERO('0'),
    ONE('1'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    FSLASH('/'),
    BSLASH('\\'),
    LINE('|'),
    LESSER('<'),
    GREATER('>'),
    PERIOD('.'),
    QUESTION('?'),
    ASTERISK('*'),
    TM('\u2122'),
    COPY('\u00A9'),
    A, B, C, D, E, F, G, H, I, J, K, L, M, O, P, Q, R, S, T, U, V, W, X, Y, Z;


    private final ResourceLocation textureOn, textureOff;
    private final char symbol;

    EnumSymbol(char symbol)
    {
        this.symbol = symbol;
        textureOn = setResourceLocation(true);
        textureOff = setResourceLocation(false);
    }

    EnumSymbol()
    {
        this.symbol = this.name().charAt(0);
        textureOn = setResourceLocation(true);
        textureOff = setResourceLocation(false);
    }

    private ResourceLocation setResourceLocation(boolean on)
    {
        switch (symbol)
        {
            default:
                return getResourceLocationOffName(Character.toString(symbol), on);
            case '|':
                return getResourceLocationOffName("line", on);
            case '\\':
                return getResourceLocationOffName("bslash", on);
            case '/':
                return getResourceLocationOffName("fslash", on);
            case ':':
                return getResourceLocationOffName("colon", on);
            case ';':
                return getResourceLocationOffName("semicolon", on);
            case '<':
                return getResourceLocationOffName("left", on);
            case '>':
                return getResourceLocationOffName("right", on);
            case '.':
                return getResourceLocationOffName("period", on);
            case '*':
                return getResourceLocationOffName("star", on);
            case '?':
                return getResourceLocationOffName("question", on);
        }
    }

    private static ResourceLocation getResourceLocationOffName(String name, boolean on)
    {
        return new ResourceLocation("tubetech:models/symbols/" + name + (on ? "_on" : "") + ".png");
    }

    public ResourceLocation getTexture(boolean on)
    {
        return on ? textureOn : textureOff;
    }
}
