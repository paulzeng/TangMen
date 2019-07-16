package com.panguaxe.sky.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 * @Title StringUnicodeSerializerUtil
 * @Description // TODO
 * @Author 作者：Mike Cium
 * @Version: 1.0
 * @Date 2019/7/12 17:30
 **/
public class StringUnicodeSerializerUtil extends JsonSerializer<String> {

    private final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
    private final int[] ESCAPE_CODES = CharTypes.get7BitOutputEscapes();

    private void writeUnicodeEscape(JsonGenerator gen, char c) throws IOException {
        gen.writeRaw('\\');
        gen.writeRaw('u');
        gen.writeRaw(HEX_CHARS[(c >> 12) & 0xF]);
        gen.writeRaw(HEX_CHARS[(c >> 8) & 0xF]);
        gen.writeRaw(HEX_CHARS[(c >> 4) & 0xF]);
        gen.writeRaw(HEX_CHARS[c & 0xF]);
    }

    private void writeShortEscape(JsonGenerator gen, char c) throws IOException{
        gen.writeRaw('\\');
        gen.writeRaw(c);
    }

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException,JsonProcessingException {
        int status = ((JsonWriteContext) jsonGenerator.getOutputContext()).writeValue();
        switch (status) {
            case JsonWriteContext.STATUS_OK_AFTER_COLON:
                jsonGenerator.writeRaw(':');
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COMMA:
                jsonGenerator.writeRaw(',');
                break;
            case JsonWriteContext.STATUS_EXPECT_NAME:
                throw new JsonGenerationException("Can not write string value here");
            default :
                jsonGenerator.writeRaw(':');
        }
    }
}
