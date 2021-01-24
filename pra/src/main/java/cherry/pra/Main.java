package cherry.pra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		InputStream input = Main.class.getResourceAsStream("/book.json");
//		ObjectMapper mapper = new ObjectMapper();
		ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Book book = mapper.readValue(input, Book.class);
		System.out.println(book);

		String json = mapper.writeValueAsString(book);
		System.out.println(json);
	}
}
