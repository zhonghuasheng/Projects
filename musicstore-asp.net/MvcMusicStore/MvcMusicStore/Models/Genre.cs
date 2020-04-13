using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
//添加命名空间
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace MvcMusicStore.Models
{
    /// <summary>
    /// 音乐类型
    /// </summary>
    public class Genre
    {
        //添加 一个属性
        public string Name{get;set;}
        [DisplayName("年代")]
        public int GenreId { get; set; }
        public string Description { get; set; }
        public List<Album> Albums { get; set; }
    }
}