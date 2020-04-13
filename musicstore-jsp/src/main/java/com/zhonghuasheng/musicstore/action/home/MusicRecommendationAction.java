package com.zhonghuasheng.musicstore.action.home;

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

@WebServlet("/musicRecommendation")
public class MusicRecommendationAction extends HttpServlet {

    private MusicService musicService = new MusicServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(1);
        pagination.setTotalPage(10);

        List<Music> musics = musicService.find(pagination);
        pagination.setData(musics);
        JSONObject result = new JSONObject(pagination);
        resp.getWriter().write(result.toString());
    }
}
