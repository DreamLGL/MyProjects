package dream.lgl.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dream.lgl.domain.Province;
import dream.lgl.service.ProvinceService;
import dream.lgl.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* //1.调用service查询
        ProvinceService service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();
        //2.序列化list为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writer().writeValueAsString(list);
        System.out.println(json);*/
        //1.调用service查询
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();
        //3.响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
