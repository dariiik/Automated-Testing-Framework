import java.beans.Transient;

import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigure; 
import org.springframework.boot.test.context.SpringBootTest; 
import org.springframework.test.web.servlet.MockMvc; 
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc 
//any of your prev classes 

public class TaskControllerTest { 
    @Autowired 
    private MockMvc mockMvc; 

    @Test
    public void testGetAllTasks() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test 
    public void testCreateTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
               .contentType("application/json")
               .content("{\"description\":\"Test task\"}"))
               .andExpect(MockMvcResultMatchers.status().iscreated()); 
    }
}
