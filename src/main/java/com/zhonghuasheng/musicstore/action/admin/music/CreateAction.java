package com.zhonghuasheng.musicstore.action.admin.music;

import com.zhonghuasheng.musicstore.common.Constants;
import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.model.Music;
import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.MusicService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;
import com.zhonghuasheng.musicstore.service.impl.MusicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(urlPatterns = "/admin/music/create")
@MultipartConfig
public class CreateAction extends HttpServlet {

    private ArtistService artistService = new ArtistServiceImpl();
    private MusicService musicService = new MusicServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Artist> artists = artistService.list();
        request.setAttribute("artists", artists);
        request.getRequestDispatcher("/WEB-INF/html/admin/music/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Music music = new Music();
        if (!validate(request, music)) {
            request.setAttribute("music", music);
            doGet(request, response);
        } else {
            Music result = musicService.create(music);
            if (result == null) {
                doGet(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/music/list");
            }
        }
    }

    private boolean validate(HttpServletRequest request, Music music) {
        boolean result = true;

        if (request.getParameter("title") == null) {
            result = false;
            request.setAttribute("msg-title", "请输入音乐名");
        } else {
            music.setTitle(request.getParameter("title"));
        }

        if (request.getParameter("artistUuid") == null) {
            result = false;
            request.setAttribute("msg-artistUuid", "请选择艺术家");
        } else if (artistService.get(request.getParameter("artistUuid")) == null) {
            result = false;
            request.setAttribute("msg-artistUuid", "请选择艺术家");
        } else {
            music.setArtistUuid(request.getParameter("artistUuid"));
        }

        if (request.getParameter("publishDate") == null || Constants.BLANK.equals(request.getParameter("publishDate"))) {
            music.setPublishDate(null);
        } else {
            try {
                music.setPublishDate(new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("publishDate")).getTime()));
            } catch (ParseException e) {
                result = false;
                request.setAttribute("msg-publishDate", "日期格式错误");
            }
        }

        if (request.getParameter("publishCompany") == null) {
            music.setPublishCompany(Constants.BLANK);
        } else {
            music.setPublishCompany(request.getParameter("publishCompany"));
        }

        return result;
    }
}