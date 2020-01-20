package com.zhonghuasheng.musicstore.action.music;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.model.Music;
import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.MusicService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;
import com.zhonghuasheng.musicstore.service.impl.MusicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 音乐详情类。普通用户点击某个音乐进入音乐详情界面，可浏览音乐详情，同时也可以将该音乐加入购物车，或者直接下单。
 */
@WebServlet(urlPatterns = {"/music/view"})
public class ViewAction extends HttpServlet {

    private MusicService musicSerice = new MusicServiceImpl();
    private ArtistService artistService = new ArtistServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");
        Music music = musicSerice.get(uuid);
        Artist artist = artistService.get(music.getArtistUuid());
        request.setAttribute("music", music);
        request.setAttribute("artist", artist);
        request.getRequestDispatcher("/WEB-INF/html/music/view.jsp").forward(request, response);
    }
}
