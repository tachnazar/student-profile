package se331.lab.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se331.lab.rest.entity.Student;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = RestApplication.class
)
@AutoConfigureMockMvc
@ActiveProfiles("dbDao")
public class RestControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getStudentsTest() throws Exception{

        mvc.perform(get("/students"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(5)))
                .andExpect(jsonPath("$[?(@.studentId=='SE-001')].name",contains("Prayuth")))
                .andExpect(jsonPath("$[?(@.studentId=='SE-001')].enrolledCourses.*.courseId",containsInAnyOrder("953xxx","953331","953234","953494")));

    }

    @Test
    public void getLecturesTest() throws Exception{

        mvc.perform(get("/lecturers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[*].name",containsInAnyOrder("Chartchai","Jayakrit","Pree")))
                .andExpect(jsonPath("$[?(@.name=='Chartchai')].advisees[*].name",containsInAnyOrder("Prayuth","Cherprang")))
                .andExpect(jsonPath("$[?(@.name=='Chartchai')].courses[*].courseId",containsInAnyOrder("953xxx","953234")))
                .andExpect(jsonPath("$[?(@.name=='Jayakrit')].advisees[*].name",contains("Nobi")))
                .andExpect(jsonPath("$[?(@.name=='Jayakrit')].courses[*].courseId",containsInAnyOrder("953331")));

    }
}
