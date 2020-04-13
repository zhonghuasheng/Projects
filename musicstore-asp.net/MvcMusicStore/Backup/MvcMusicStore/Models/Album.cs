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
    [Bind(Exclude="AlbumId")]
    public class Album
    {
        [DisplayName("年代")]
        public int GenreId { get; set; }
        [ScaffoldColumn(false)]
        public int AlbumId { get; set; }
        [DisplayName("艺术家")]
        public int ArtistId { get; set; }
        [Required(ErrorMessage="*必填")]
        [StringLength(160)]
        [DisplayName("歌名")]
        public string Title { get; set; }
        [Required(ErrorMessage="*必填")]
        [Range(0.01,100.00,ErrorMessage="*价格区间必须在0.01-100.00")]
        [DisplayName("价格")]
        public decimal Price { get; set; }
        [DisplayName("专辑显示位置-可不填")]
        [StringLength(1024)]
        public string AlbumArtUrl { get; set; }
        //将Genre、Artist属性设置为虚拟的可使EF-Code First使用延迟加载
        [DisplayName("年代")]
        public virtual Genre Genre { get; set; }
        [DisplayName("艺术家")]
        public virtual Artist Artist { get; set; }
        public virtual List<OrderDetail> OrderDetails { get; set; }
    }
}