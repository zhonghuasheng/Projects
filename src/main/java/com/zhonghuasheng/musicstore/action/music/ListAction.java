package com.zhonghuasheng.musicstore.action.music;

import com.zhonghuasheng.musicstore.model.Music;
import com.zhonghuasheng.musicstore.model.Pagination;
import com.zhonghuasheng.musicstore.service.MusicService;
import com.zhonghuasheng.musicstore.service.impl.MusicServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/music/", "/admin/music/list", "/admin/music"})
public class ListAction extends HttpServlet {

    private MusicService musicService = new MusicServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/html/music/list.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pagination pagination = new Pagination();
        int currentPage = 1;
        int pageSize = 10;

        try {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
        } catch (NumberFormatException nfe) {
        }

        try {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        } catch (NumberFormatException nfe) {
        }

        pagination.setCurrentPage(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setKey(request.getParameter("key"));

        List<Music> musics = musicService.find(pagination);
        pagination.setData(musics);
        pagination.setTotalPage((musicService.count() + pagination.getPageSize() - 1) / pagination.getPageSize());

        JSONObject result = new JSONObject(pagination);
        response.getWriter().write(result.toString());
    }
}