package com.zhonghuasheng.musicstore.action.artist;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.zhonghuasheng.musicstore.model.Artist;
import com.zhonghuasheng.musicstore.service.ArtistService;
import com.zhonghuasheng.musicstore.service.impl.ArtistServiceImpl;

@WebServlet(urlPatterns = "/admin/artist/create")
@MultipartConfig
public class CreateAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part avatarFile = request.getPart("avatar");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String region = request.getParameter("region");
        String experience = request.getParameter("experience");
        System.out.println(name +":" + birthday + ":" + region + ":" + experience);

        Artist artist = new Artist();
        artist.setExperience(experience);
        artist.setName(name);
        artist.setRegion(region);
        try {
            artist.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Gets upload folder
        String root = request.getServletContext().getRealPath("/document-upload/avatar/");
        // Gets file name
        String fileName = avatarFile.getHeader("content-disposition");
        // Gets suffix of avatar
        String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length() - 1);
        String newFileName = UUID.randomUUID().toString() + suffix;
        avatarFile.write(root + newFileName);
        artist.setAvatar(newFileName);

        ArtistService artistService = new ArtistServiceImpl();
        Artist result = artistService.create(artist);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/artist/create.jsp").forward(request, response);
    }
}
