using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
//添加命名空间
using System.Collections.Generic;
using System.Web.Mvc;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel;


namespace MvcMusicStore.Models
{
    [Bind(Exclude = "OrderID")]
    public class Order
    {
        [ScaffoldColumn(false)]
        //ScaffoldColumn  表示的是是否采用MVC框架来处理 设置为true表示采用MVC框架来处理，如果设置为false，则该字段不会在View层显示，里面定义的验证也不会生效
        public int OrderId { get; set; }
        [ScaffoldColumn(false)]
        [DisplayName("用户名")]
        public string UserName { get; set; }
        [Required(ErrorMessage="*必填")]
        [DisplayName("姓")]
        [StringLength(10)]
        public string FirstName { get; set; }
        [Required(ErrorMessage="*必填")]
        [DisplayName("名")]
        [StringLength(10)]
        public string LastName { get; set; }
        [Required(ErrorMessage="*必填")]
        [DisplayName("地址")]
        [StringLength(170)]
        public string Address { get; set; }
        [Required(ErrorMessage="*必填")]
        [DisplayName("所在城市")]
        [StringLength(70)]
        public string City { get; set; }
        [Required(ErrorMessage="*必填")]
        [DisplayName("所在省份")]
        [StringLength(70)]
        public string State { get; set; }
        [Required(ErrorMessage="*必填")]
        [DisplayName("邮编")]
        [StringLength(10)]
        public string PostalCode { get; set; }
        [Required(ErrorMessage="*必填")]
        [DisplayName("乡镇")]
        [StringLength(100)]
        public string Country { get; set; }
        [Required(ErrorMessage = "*必填")]
        [DisplayName("电话号码")]
        [StringLength(20)]
        public string Phone { get; set; }
        [Required(ErrorMessage = "*必填")]
        [DisplayName("邮箱")]
        [RegularExpression(@"[A-Za-z0-9]+@[A-Za-z0-9]+\.[A-Za-z]{2,4}",ErrorMessage="邮箱格式不正确")]
        [DataType(DataType.EmailAddress)]
        public string Email { get; set; }
        [ScaffoldColumn(false)]
        public decimal Total { get; set; }
        [ScaffoldColumn(false)]
        public System.DateTime OrderDate { get; set; }
        public List<OrderDetail> OrderDetail { get; set; }
    }
}