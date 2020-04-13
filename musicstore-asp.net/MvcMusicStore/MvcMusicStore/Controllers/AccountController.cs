using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;
using System.Web.Security;
using Mvc3ToolsUpdateWeb_Default.Models;
using MvcMusicStore.Models;

namespace Mvc3ToolsUpdateWeb_Default.Controllers
{
    public class AccountController : Controller
    {
        /// <summary>
        /// 登录
        /// </summary>
        /// <returns></returns>
        public ActionResult LogOn()
        {
            return View();
        }

        /// <summary>
        /// 登录
        /// </summary>
        /// <param name="model">登录Model</param>
        /// <param name="returnUrl">返回链接地址</param>
        /// <returns></returns>
        [HttpPost]
        public ActionResult LogOn(LogOnModel model, string returnUrl)
        {
            if (ModelState.IsValid)
            {
                //验证用户名和密码
                if (Membership.ValidateUser(model.UserName, model.Password))
                {
                    //为提供的用户名创建一个身份验证票证，并将该票证添加到响应的 Cookie 集合中或 URL 中（如果使用的是无 Cookie 身份验证）。
                    FormsAuthentication.SetAuthCookie(model.UserName, model.RememberMe);
                    //判断此时的Url是否是本地的地址
                    if (Url.IsLocalUrl(returnUrl) && returnUrl.Length > 1 && returnUrl.StartsWith("/")
                        && !returnUrl.StartsWith("//") && !returnUrl.StartsWith("/\\"))
                    {
                        //return RedirectToAction("Index", "Home");
                        return Redirect(returnUrl);
                    }
                    else
                    {
                        return RedirectToAction("Index", "Home");
                        //return Redirect(returnUrl);
                    }
                }
                else
                {
                    ModelState.AddModelError("", "用户名或密码错误.");
                }
            }
            return View(model);
        }

        
        public ActionResult LogOff()
        {
            FormsAuthentication.SignOut();

            return RedirectToAction("Index", "Home");
        }

        //
        // GET: /Account/Register

        public ActionResult Register()
        {
            return View();
        }

        //注册用户
        [HttpPost]
        public ActionResult Register(RegisterModel model)
        {
            if (ModelState.IsValid)
            {
                // Attempt to register the user
                MembershipCreateStatus createStatus;
                Membership.CreateUser(model.UserName, model.Password, model.Email, "question", "answer", true, null, out createStatus);

                if (createStatus == MembershipCreateStatus.Success)
                {
                    FormsAuthentication.SetAuthCookie(model.UserName, false /* createPersistentCookie */);
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    ModelState.AddModelError("", ErrorCodeToString(createStatus));
                }
            }

            // If we got this far, something failed, redisplay form
            return View(model);
        }

        //
        // GET: /Account/ChangePassword

        [Authorize]
        public ActionResult ChangePassword()
        {
            return View();
        }

        //
        // POST: /Account/ChangePassword

        [Authorize]
        [HttpPost]
        public ActionResult ChangePassword(ChangePasswordModel model)
        {
            if (ModelState.IsValid)
            {

                // ChangePassword will throw an exception rather
                // than return false in certain failure scenarios.
                bool changePasswordSucceeded;
                try
                {
                    MembershipUser currentUser = Membership.GetUser(User.Identity.Name, true /* userIsOnline */);
                    changePasswordSucceeded = currentUser.ChangePassword(model.OldPassword, model.NewPassword);
                }
                catch (Exception)
                {
                    changePasswordSucceeded = false;
                }

                if (changePasswordSucceeded)
                {
                    return RedirectToAction("ChangePasswordSuccess");
                }
                else
                {
                    ModelState.AddModelError("", "当前密码不正确或新密码无效.");
                }
            }

            // If we got this far, something failed, redisplay form
            return View(model);
        }

        //
        // GET: /Account/ChangePasswordSuccess

        public ActionResult ChangePasswordSuccess()
        {
            return View("ChangePassword");
        }

        #region Status Codes
        private static string ErrorCodeToString(MembershipCreateStatus createStatus)
        {
            // See http://go.microsoft.com/fwlink/?LinkID=177550 for
            // a full list of status codes.
            switch (createStatus)
            {
                case MembershipCreateStatus.DuplicateUserName:
                    return "用户名已存在，请重新输入.";

                case MembershipCreateStatus.DuplicateEmail:
                    return "该邮箱已注册过，请选择另外一个邮箱.";

                case MembershipCreateStatus.InvalidPassword:
                    return "提供的密码是无效的.请输入一个有效的密码.";

                case MembershipCreateStatus.InvalidEmail:
                    return "无效的邮箱.";

                case MembershipCreateStatus.InvalidAnswer:
                    return "密保答案无效，请重试.";

                case MembershipCreateStatus.InvalidQuestion:
                    return "密保答案无效，请重试.";

                case MembershipCreateStatus.InvalidUserName:
                    return "用户名无效，请重试.";

                case MembershipCreateStatus.ProviderError:
                    return "邮箱验证错误，请确认你的输入,再试一次.如果问题仍然存在,请联系您的系统管理员.";

                case MembershipCreateStatus.UserRejected:
                    return "用户创建的请求已经被取消了，请确认你的输入,再试一次.如果问题仍然存在,请联系您的系统管理员.";

                default:
                    return "未知错误，请重试，如果还是不行，请联系管理员.";
            }
        }
        #endregion

        private void MigrateShoppingCart(string UserName)
        {
            var cart = ShoppingCart.GetCart(this.HttpContext);
            cart.MigrateCart(UserName);
            Session[ShoppingCart.CartSessionKey] = UserName;
        }
    }
}
