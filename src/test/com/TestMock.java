package test.com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.controller.HomeCtrl;
import com.entity.Spittle;
import com.repository.SpitterImpl;
import com.repository.SpitterRepository;
import com.repository.SpittlRepository;


public class TestMock {
	@Test
	public void testSpring() throws Exception{
		HomeCtrl home = new HomeCtrl();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(home).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("index"));
	}
	
	@Test
	public void testRtrSpilltes() throws Exception{
		SpittlRepository repository = Mockito.mock(SpittlRepository.class);
		Mockito.when(repository.findSpittles(2, 5)).thenReturn(createSpittles(2, 5));
		
		HomeCtrl homeCtrl = new HomeCtrl(repository);
	
		MockMvc mvc =  MockMvcBuilders.standaloneSetup(homeCtrl)
				.setSingleView(new InternalResourceView("/WEB-INF/views/mypage"))
				.build();
		mvc.perform(MockMvcRequestBuilders.get("/spittles"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("mydatas"))
		.andExpect(MockMvcResultMatchers.view().name("spittles"));
	}

	private List<Spittle> createSpittles(int i, int j) {
		List<Spittle> spittles = new ArrayList<>();
		for(int k=0;k<20;k++){
			spittles.add(new Spittle("test", new Date()));
		}
		return spittles;
	}
	
	
	@Test
	public void testSpitter() throws Exception{
		HomeCtrl homeCtrl = new HomeCtrl();
		SpitterRepository repository = new SpitterImpl();
		homeCtrl.setSpitterRepository(repository);
		MockMvc mvc = MockMvcBuilders.standaloneSetup(homeCtrl).build();
		mvc.perform(MockMvcRequestBuilders.post("/register")
				.param("username", "d")
				.param("password", "test123")
				).andExpect(MockMvcResultMatchers.view().name("registerForm"));
	}
}
