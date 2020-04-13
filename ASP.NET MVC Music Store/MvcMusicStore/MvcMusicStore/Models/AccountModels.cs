using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Web.Mvc;
using System.Web.Security;

namespace Mvc3ToolsUpdateWeb_Default.Models
{

    public class ChangePasswordModel
    {
        [Required]
        //设置密码格式
        [DataType(DataType.Password)]
        [Display(Name = "旧密码")]
        public string OldPassword { get; set; }

        [Required]
        [StringLength(100, ErrorMessage = " {0} 至少 {2} 个字符长度，并且包含一个特殊字符.", MinimumLength = 7)]
        [DataType(DataType.Password)]
        [Display(Name = "新密码")]
        public string NewPassword { get; set; }

        [DataType(DataType.Password)]
        [Display(Name = "确认密码")]
        [Compare("NewPassword", ErrorMessage = "确认密码与新密码不一致.")]
        public string ConfirmPassword { get; set; }
    }

    public class LogOnModel
    {
        [Required]
        [Display(Name = "用户名")]
        public string UserName { get; set; }

        [Required]
        [DataType(DataType.Password)]
        [Display(Name = "密码")]
        public string Password { get; set; }

        [Display(Name = "记住用户名和密码?")]
        public bool RememberMe { get; set; }
    }

    public class RegisterModel
    {
        [Required]
        [Display(Name = "用户名")]
        public string UserName { get; set; }

        [Required]
        [DataType(DataType.EmailAddress)]
        [Display(Name = "邮箱")]
        public string Email { get; set; }

        [Required]
        [StringLength(100, ErrorMessage = " {0} 至少 {2} 个字节长度，并且包含一个特殊字符.", MinimumLength = 7)]
        [DataType(DataType.Password)]
        [Display(Name = "密码")]
        public string Password { get; set; }

        [DataType(DataType.Password)]
        [Display(Name = "确认密码")]
        [Compare("Password", ErrorMessage = "确认密码与密码不一致.")]
        public string ConfirmPassword { get; set; }
    }
}
