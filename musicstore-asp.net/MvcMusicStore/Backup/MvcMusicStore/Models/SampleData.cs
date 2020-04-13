using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace MvcMusicStore.Models
{
    public class SampleData : DropCreateDatabaseIfModelChanges<MusicStoreEntities>
    {
        protected override void Seed(MusicStoreEntities context)
        {
            //增加音乐类型
            var genres = new List<Genre>
            {
                #region 年代
		        new Genre { Name = "流金岁月" },
                new Genre { Name = "古风" },
                new Genre { Name = "红歌" },
                new Genre { Name = "70后" },
                new Genre { Name = "80后" },
                new Genre { Name = "90后" },
                new Genre { Name = "00后" } 
	#endregion
            };
            //增加艺术家类型
            var artists = new List<Artist>
            {
                #region 艺术家
		        new Artist { Name = "杨钰莹" },
                new Artist { Name = "罗大佑" },
                new Artist { Name = "李克勤" },
                new Artist { Name = "张雨生" },
                new Artist { Name = "刘欢" },
                new Artist { Name = "河图" },
                new Artist { Name = "董贞" },
                new Artist { Name = "陈思思" },
                new Artist { Name = "屠洪刚" },
                new Artist { Name = "刀郎" },
                new Artist { Name = "孟文豪" },
                new Artist { Name = "周华健" },
                new Artist { Name = "罗文" },
                new Artist { Name = "谭咏麟" },
                new Artist { Name = "叶丽仪" },
                new Artist { Name = "那英" },
                new Artist { Name = "刘若英" },
                new Artist { Name = "汪峰" },
                new Artist { Name = "王菲" },
                new Artist { Name = "周杰伦" },
                new Artist { Name = "郁可唯" },
                new Artist { Name = "徐良" },
                new Artist { Name = "杨宗纬" } 
	#endregion
            };
            //歌曲
            new List<Album>
            {
                #region 流金岁月
		new Album { Title = "心雨", Genre = genres.Single(g => g.Name == "流金岁月"), Price = 8.99M, Artist = artists.Single(a => a.Name == "杨钰莹"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "童年", Genre = genres.Single(g => g.Name == "流金岁月"), Price = 8.99M, Artist = artists.Single(a => a.Name == "罗大佑"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album{Title="红日",Genre=genres.Single(g=>g.Name=="流金岁月"),Price=8.99M,Artist=artists.Single(a=>a.Name=="李克勤"),AlbumArtUrl="/Content/Images/placeholder.gif"},
                new Album{Title="大海",Genre=genres.Single(g=>g.Name=="流金岁月"),Price=8.99M,Artist=artists.Single(a=>a.Name=="张雨生"),AlbumArtUrl="/Content/Images/placeholder.gif"}, 
	#endregion
                #region 古风
		new Album { Title = "凤凰于飞", Genre = genres.Single(g => g.Name == "古风"), Price = 8.99M, Artist = artists.Single(a => a.Name == "刘欢"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "倾尽天下", Genre = genres.Single(g => g.Name == "古风"), Price = 8.99M, Artist = artists.Single(a => a.Name == "河图"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "刀剑如梦", Genre = genres.Single(g => g.Name == "古风"), Price = 8.99M, Artist = artists.Single(a => a.Name == "董贞"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "醉梦仙霖", Genre = genres.Single(g => g.Name == "古风"), Price = 8.99M, Artist = artists.Single(a => a.Name == "董贞"), AlbumArtUrl = "/Content/Images/placeholder.gif" }, 
	#endregion
                #region 红歌
		new Album { Title = "中国梦", Genre = genres.Single(g => g.Name == "红歌"), Price = 8.99M, Artist = artists.Single(a => a.Name ==   "陈思思"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "红星照我去战斗", Genre = genres.Single(g => g.Name == "红歌"), Price = 8.99M, Artist = artists.Single(a => a.Name =="刀郎"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "中国有力量", Genre = genres.Single(g => g.Name == "红歌"), Price = 8.99M, Artist = artists.Single(a => a.Name =="孟文豪"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "精忠报国", Genre = genres.Single(g => g.Name == "红歌"), Price = 8.99M, Artist = artists.Single(a => a.Name == "屠洪刚"), AlbumArtUrl = "/Content/Images/placeholder.gif" }, 
	#endregion
                #region 70后
		new Album { Title = "风雨无阻", Genre = genres.Single(g => g.Name == "70后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "周华健"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "铁血丹心", Genre = genres.Single(g => g.Name == "70后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "罗文"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "水中花", Genre = genres.Single(g => g.Name == "70后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "谭咏麟"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "上海滩", Genre = genres.Single(g => g.Name == "70后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "叶丽仪"), AlbumArtUrl = "/Content/Images/placeholder.gif" }, 
	#endregion
                #region 80后
		new Album { Title = "存在", Genre = genres.Single(g => g.Name == "80后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "汪峰"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                 new Album { Title = "白天不懂夜的黑", Genre = genres.Single(g => g.Name == "80后"), Price = 8.99M, Artist = artists.Single(a => a.Name =="那英"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                  new Album { Title = "后来", Genre = genres.Single(g => g.Name == "80后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "刘若英"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "红豆", Genre = genres.Single(g => g.Name == "80后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "王菲"), AlbumArtUrl = "/Content/Images/placeholder.gif" }, 
	#endregion
                #region 90后
		 new Album { Title = "红尘客栈", Genre = genres.Single(g => g.Name == "90后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "周杰伦"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                 new Album { Title = "时间煮雨", Genre = genres.Single(g => g.Name == "90后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "郁可唯"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                  new Album { Title = "情话", Genre = genres.Single(g => g.Name == "90后"), Price = 8.99M, Artist = artists.Single(a => a.Name == "徐良"), AlbumArtUrl = "/Content/Images/placeholder.gif" },
                new Album { Title = "洋葱", Genre = genres.Single(g => g.Name == "90后"), Price = 8.99M, Artist = artists.Single(a => a.Name =="杨宗纬"), AlbumArtUrl = "/Content/Images/placeholder.gif" }, 
	#endregion
            }.ForEach(a => context.Albums.Add(a));
        }
    }
}