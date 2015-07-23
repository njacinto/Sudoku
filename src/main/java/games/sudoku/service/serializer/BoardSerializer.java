/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games.sudoku.service.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import games.sudoku.model.Board;
import java.io.IOException;

/**
 *
 * @author nuno
 */
public class BoardSerializer extends JsonSerializer<Board> {

    @Override
    public void serialize(Board t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
        jg.writeStartObject();
        jg.writeObjectField("number", t.getNumber());
        jg.writeObjectField("area", t.getArea());
        jg.writeObjectField("table", t.getTable());
        jg.writeEndObject();
    }
    
}
