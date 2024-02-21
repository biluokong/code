//autosave 自动缓存输入内容
SaveForumInputCache();

//$("#totop").remove();
$(window).scroll(function () {
  if (document.body.scrollTop > 800 || document.documentElement.scrollTop > 800) {
    $('#totop').fadeIn(6000);
  } else {
    $('#totop').fadeOut(500);
  }
});

$('#totop').on('click', function (e) {
  e.preventDefault();
  $('html,body').animate({ scrollTop: 0 }, 500);
});

$('.nvl-content').css('min-height', $(window).height() - 70);
var screenWidth = $(window).width();

// var navWidth = $('.nov-title-box').width();
// var sidebarWidth = $('.main-sidebar').width();
// $('.fix-nav').width(screenWidth-sidebarWidth);
// $('.fix-nav').css('left',sidebarWidth);

$(".nvl-content").bind('mousewheel DOMMouseScroll', function (event) {
  if (event.originalEvent.wheelDelta > 0 || event.originalEvent.detail < 0) {

    var header = document.getElementById("novel-header").offsetTop;
    if (header < $(window).scrollTop() && header < ($(window).scrollTop() + $(window).height())) {
      $("#novel-header").css("height", "40px");
    } else {
      $("#novel-header").css("height", "0px");
    }

  } else {
    $("#novel-header").css("height", "0px");
  }
});

var isActive = true;
var refresh = new Date().getTime();
var change_num = 0;

$(document).on('visibilitychange', function (e) {
  if (e.target.visibilityState === "visible") {
    isActive = false;
    refresh = new Date().getTime();
    change_num++;
  } else if (e.target.visibilityState === "hidden") {
    isActive = false;
  }
});

// $(".nvl-content").scroll(function () {
// 	var header = document.getElementById("novel-header").offsetTop;
// 	if (header >= $(window).scrollTop() && header < ($(window).scrollTop()+$(window).height())) {
// 		//$("#novel-header").css("height","40px");
// 		//$("#novel-header").hide();
// 	}
// });


$(".nvl-content").on("touchstart", function (e) {

  startX = e.originalEvent.changedTouches[0].pageX,
    startY = e.originalEvent.changedTouches[0].pageY;
});
$(".nvl-content").on("touchend", function (e) {

  moveEndX = e.originalEvent.changedTouches[0].pageX,
    moveEndY = e.originalEvent.changedTouches[0].pageY,
    X = moveEndX - startX,
    Y = moveEndY - startY;
  // dont react if user is swiping left and right
  if (Math.abs(X) > Math.abs(Y)) { return; }
  // dont react if user is swiping just a little
  if (Math.abs(Y) < 10) { return; }

  if (Y > 0) {
    var header = document.getElementById("novel-header").offsetTop;
    if (header < $(window).scrollTop() && header < ($(window).scrollTop() + $(window).height())) {
      $("#novel-header").css("height", "40px");
    } else {
      $("#novel-header").css("height", "0px");
    }

  } else if (Y < 0) {
    $("#novel-header").css("height", "0px");
  }
});

$('body').on('click', '.back-chapter', function () {
  var novel_id = $(this).attr("data-nid");
  window.location.href = "/admin/novelView?novel_id=" + novel_id;
})

$(".chapter-list").click(function () {
  if ($('.chapter-nav').hasClass('checked')) {
    $(".chapter-nav").css("width", "0px");
    $(".chapter-nav").removeClass("checked");
  } else {
    if (screenWidth > 1000) {
      $(".chapter-nav").css("width", "30%");
    } else {
      $(".chapter-nav").css("width", "60%");
    }

    $(".chapter-nav").addClass("checked");
  }
})



$('body').on('click', '.nvl-content', function () {
  if ($('.chapter-nav').hasClass('checked')) {
    $(".chapter-nav").css("width", "0px");
    $(".chapter-nav").removeClass("checked");
  }
})

$('body').on('click mouseover', '.episode-box', function () {
  if (!$(this).hasClass('bookmark')) {
    $('.bookmark').removeClass('bookmark');
  }
})

$('body').on('mouseout', '.episode-box', function () {
  if (!$(this).hasClass('bookmark')) {
    $('.marked').addClass('bookmark');
  }
})

$('body').on('click', '.chapter-box', function () {
  var episode = $(this).next().children('.episode-ul');
  var sign = $(this).children('.sign');
  if ($(this).hasClass('minus')) {
    $(this).removeClass('minus');
    $(this).addClass('plus');
    episode.css("height", "0px");
    sign.html("+");
  } else if ($(this).hasClass('plus')) {
    var height = episode.attr("data-enum") * 50;
    $(this).removeClass('plus');
    $(this).addClass('minus');
    episode.css("height", height);
    sign.html("-");
  }
})


function hideOverFlow1(obj) {
  obj.each(function () {
    var hei = $(this).height();
    if (hei > 200) {
      $(this).css("max-height", "600px");
      $(this).next().append('<i class="glyphicon glyphicon-chevron-down show-over-flow" >展开</i>');
    }
  });
}

function hideOverFlow2(obj) {
  obj.each(function () {
    var hei = $(this).height();
    if (hei > 100) {
      $(this).css("max-height", "300px");
      $(this).next().prepend('<i class="glyphicon glyphicon-chevron-down show-over-flow-reply" style="margin-right:5px" >展开</i>');
    }
  });
}

function initOverFlow() {
  var cc = $('.comment-content');
  var rb = $('.reply-box');
  hideOverFlow1(cc);
  hideOverFlow2(rb);
}

initOverFlow();

function clearEditor() {
  if (window.refreshComment) {
    window.refreshComment();
    return;
  }
  $('.w-e-text').html("<p><br></p>");
  $('#parent_comment').val('');
  $('#top_comment').val('');
  $('#reply_user').val('');
  $('#comment').val('');
}

function initComment() {
  init_time();
  initOverFlow();
  clearEditor();
  aedamn_main();
}






var screenWidth = $(window).width();

$.ajaxSetup({
  headers: {
    'X-CSRF-TOKEN': $('.csrf').val()
  }
});

function addcomment(type, id, content, comment_id) {
  const numHtml = $('.comment_list').children(":first").html();
  const commentNum = numHtml.substring(numHtml.indexOf('(') + 2, numHtml.indexOf(')') - 1);
  const commentNumNew = parseInt(commentNum) + 1;
  $('.comment_list').children(":first").html(numHtml.replace(commentNum, commentNumNew));
  let self_id = document.getElementsByClassName("user-header")[0].getElementsByTagName("small")[0].textContent;
  self_id = parseInt(self_id.substring(self_id.indexOf('ID') + 3));
  if (type == 1) {//小说评论
    const pages = parseInt($('.pagination li:nth-last-of-type(2)').children(":first").text());
    if (pages > 1) {
      const currentPage = parseInt($('.page-item.active').children(":first").text());
      if (currentPage != pages) {//若当前所在评论页码非最后一页，无需拼接
        return;
      }
    }
    let cfloor = $('.c-floor').last().text();
    if (cfloor == '') {
      cfloor = 1;
    } else {
      cfloor = parseInt(cfloor.substring(0, cfloor.length - 1)) + 1;
    }
    const commentHtml = '<hr><div class="comment "><div class="left-box"><div data-uid="' + self_id + '" class="imgdiv user-info-show"><img src="' +
      $('.user-image').attr('src') +
      '" class="imgcss"></div> <div data-id="' + comment_id +
      '" data-type="2" class="thumbs-up fake-do"><i class="glyphicon glyphicon-thumbs-up">(0)</i></div></div> \
<div class="comment-details"><div class="comment-title"><span class="comment_name">'+
      $('.hidden-xs').text() +
      '</span> <span class="c-floor">' +
      cfloor +
      '楼</span> <span class="time">  刚刚</span></div> <div class="del"><a data-id="' + comment_id +
      '" class="del_comment"><i class="fa fa-trash">删除</i></a></div> <div data-uid="' + self_id + '" data-id="' + comment_id +
      '" data-avatar="' +
      $('.user-image').attr('src') +
      '" data-name="' + $('.hidden-xs').text() +
      '" class="comment-content"><div class="comment-escape">' +
      content + '</div></div> <div style="width: 100%;">\
          <i class="fa fa-commenting-o reply-comment" style="float: right; margin-right: 20px; margin-bottom: 8px;">回复</i></div></div> \
          <div class="reply_list"></div></div>';
    $('.comment_list').append(commentHtml);
  } else {//小说评论之回复
    const replyNameHtml = replyUserName ? '</b> 回复 <b>' + replyUserName : '';
    replyUserName = '';
    const replyHtml = '<div class="reply "><div data-uid="' + self_id + '" class="simgdiv user-info-show"><img src="' +
      $('.user-image').attr('src') +
      '" class="simg"></div> <div class="reply-box"><span class="reply_name"><b>' +
      $('.hidden-xs').text() + replyNameHtml +
      '：</b></span> <span class="reply-btn-box"><a data-id="' + comment_id +
      '" class="del_reply"><i class="fa fa-trash">删除</i></a> <i class="fa fa-commenting-o reply-btn" style="margin-left: 40px;">回复</i></span> <span data-uid="'
      + self_id + '" data-id="' + comment_id + '" data-avatar="' +
      $('.user-image').attr('src') +
      '" data-name="' + $('.hidden-xs').text() + '" data-top="' + id + '" class="reply_content"><div class="comment-escape">' +
      content + '</div></span></div> <span class="time reply-time">  刚刚</span></div>';
    $('.comment-content[data-id="' + id + '"]').parent().next().append(replyHtml);
  }
}
var fakeThumbsUp = 1;
var replyUserName = '';
$(document).on('click', '.fake-do', function () {//给自己新发的评论虚空点赞无法获得金币经验
  if (fakeThumbsUp) {
    $(this).css('color', 'orange');
    $(this).children(":first").html("(1)");
  } else {
    $(this).css('color', 'inherit');
    $(this).children(":first").html("(0)");
  }
  fakeThumbsUp = 1 - fakeThumbsUp;
  return false;
});

layui.use(['layer', 'jquery', 'element', 'flow'], function () {
  window.layer = layui.layer;
  layedit = layui.layedit;
  window.jQuery = window.$ = layui.jquery;

  $('.nvl-content img').each(function (_) {
    const url = $(this).attr('src');
    $(this).attr({
      'lay-src': url,
      'src': '/images/load.gif',
    });
    console.log(url);
  });

  layui.flow.lazyimg();

  $(document).on('click', '.show_reply_list', function () {

    if ($(this).closest('.comment').find(".hide-reply").css("display") != "none") {
      $(this).closest('.comment').find(".show_remain_reply").css("display", "none");
      var num = $(this).attr('data-num');
      $(this).html("查看剩余" + num + "条回复");

    } else {
      $(this).closest('.comment').find(".show_remain_reply").css("display", "block");
      $(this).html("收起回复");

    }
    $(this).closest('.comment').find(".hide-reply").toggle(500);

  });

  var layer = layui.layer;

  $(document).on('click', '.reply-comment', function () {
    var comment = $(this).parent().prev();
    var avatar = comment.attr("data-avatar");
    var id = comment.attr("data-id");
    var name = comment.attr("data-name");
    var uid = comment.attr("data-uid");
    var content = comment.html();

    var html = '';
    html += '<div class="imgdiv">';
    html += '<img class="imgcss"  src="' + avatar + '"/>';
    html += '</div>';
    html += '<div class="comment-details">';
    html += '<div class="comment-title">';
    html += '<span class="comment_name">' + name + '</span>';
    html += '</div>';
    html += '<div class="comment-content">' + content + '</div>';
    html += '</div>';
    $('#comment-info').html(html);
    $('#parent_comment').val(id);
    $('#top_comment').val(id);
    $('#reply_user').val(uid);

    if (screenWidth < 1000) {
      var offset = ['0px', '0px'];
      var area = ['100%', '100%'];
      $('.w-e-text-container').height(500);
    } else {
      var offset = 'auto';
      var area = ['1000px', '500px'];
    }

    layer.open({
      type: 1,
      title: '回复',
      skin: 'layui-layer-lan',
      area: ['1000px', '500px'],
      btn: ['缓存救我', '回复'],
      area: area,
      offset: offset,
      content: $('.comment-box'),
      yes: function () {
        ReadForumInputCache()
      },
      btn2: function (index, layero) {
        var load = layer.load();
        var form = $("#commentForm").serialize();
        form += "&comment=" + encodeURIComponent($('.w-e-text').html());

        var arr = new Array();
        $.each($('.w-e-text .at-u'), function (index, value) {
          arr[index] = $(this).attr('data-id');
        });
        if (arr) {
          form += "&at=" + JSON.stringify(arr);
        }

        $.ajax({
          type: 'post',
          url: '/admin/chapterComment',
          dataType: 'json',
          data: form,
          success: function (data) {
            layer.close(load);
            if (data.code == 1) {
              layer.msg('评论成功!', { icon: 1 });
              addcomment(2, id, data.content, data.data_id);
              initComment();
            } else if (data.code == -1) {
              layer.msg(data.msg, { icon: 2 });
            } else {
              layer.msg('评论失败!', { icon: 2 });
            }
          },
          error: function (data) {
            layer.close(load);
            if (data.code == 1) {
              layer.msg('评论成功!', { icon: 1 });
              addcomment(2, id, data.content, data.data_id);
              initComment();
            } else if (data.code == -1) {
              layer.msg(data.msg, { icon: 2 });
            } else {
              if (data.responseJSON.message) {
                layer.msg(data.responseJSON.message, { icon: 2 });
              } else {
                layer.msg('网络错误，稍后重试!', { icon: 2 });
              }
            }
          }
        })
        layer.close(index);
      }
    });
  });

  $(document).on('click', '.reply-btn', function () {
    var comment = $(this).parent().next();
    var avatar = comment.attr("data-avatar");
    var id = comment.attr("data-id");
    var top = comment.attr("data-top");
    var name = comment.attr("data-name");
    replyUserName = name;
    var uid = comment.attr("data-uid");
    var content = comment.html();

    var html = '';
    html += '<div class="imgdiv">';
    html += '<img class="imgcss"  src="' + avatar + '"/>';
    html += '</div>';
    html += '<div class="comment-details">';
    html += '<div class="comment-title">';
    html += '<span class="comment_name">' + name + '</span>';
    html += '</div>';
    html += '<div class="comment-content">' + content + '</div>';
    html += '</div>';
    $('#comment-info').html(html);
    $('#parent_comment').val(id);
    $('#top_comment').val(top);
    $('#reply_user').val(uid);

    if (screenWidth < 1000) {
      var offset = ['0px', '0px'];
      var area = ['100%', '100%'];
      $('.w-e-text-container').height(500);
    } else {
      var offset = 'auto';
      var area = ['1000px', '500px'];
    }

    layer.open({
      type: 1,
      title: '回复',
      skin: 'layui-layer-lan',
      area: ['1000px', '500px'],
      btn: ['缓存救我', '回复'],
      area: area,
      offset: offset,
      content: $('.comment-box'),
      yes: function () {
        ReadForumInputCache()
      },
      btn2: function (index, layero) {
        var load = layer.load();
        var form = $("#commentForm").serialize();
        form += "&comment=" + encodeURIComponent($('.w-e-text').html());

        var arr = new Array();
        $.each($('.w-e-text .at-u'), function (index, value) {
          arr[index] = $(this).attr('data-id');
        });
        if (arr) {
          form += "&at=" + JSON.stringify(arr);
        }

        $.ajax({
          type: 'post',
          url: '/admin/chapterComment',
          dataType: 'json',
          data: form,
          success: function (data) {
            layer.close(load);
            if (data.code == 1) {
              layer.msg('评论成功!', { icon: 1 });
              addcomment(2, top, data.content, data.data_id);
              initComment();
            } else if (data.code == -1) {
              layer.msg(data.msg, { icon: 2 });
            } else {
              layer.msg('评论失败!', { icon: 2 });
            }
          },
          error: function (data) {
            layer.close(load);
            if (data.code == 1) {
              layer.msg('评论成功!', { icon: 1 });
              addcomment(2, top, data.content, data.data_id);
              initComment();
            } else if (data.code == -1) {
              layer.msg(data.msg, { icon: 2 });
            } else {
              if (data.responseJSON.message) {
                layer.msg(data.responseJSON.message, { icon: 2 });
              } else {
                layer.msg('网络错误，稍后重试!', { icon: 2 });
              }
            }
          }
        })
        layer.close(index);
      }
    });
  });

  $(document).on('click', '#comment-btn', function () {
    $('#comment-info').html('');
    $('#parent_comment').val(0);
    $('#top_comment').val(0);
    $('#reply_user').val(0);

    if (screenWidth < 1000) {
      var offset = ['0px', '0px'];
      var area = ['100%', '100%'];
      $('.w-e-text-container').height(500);
    } else {
      var offset = 'auto';
      var area = ['1000px', '500px'];
    }

    layer.open({
      type: 1,
      title: '评论',
      skin: 'layui-layer-lan',
      area: ['1000px', '400px'],
      btn: ['缓存救我', '评论'],
      area: area,
      offset: offset,
      content: $('.comment-box'),
      yes: function () {
        ReadForumInputCache()
      },
      btn2: function (index, layero) {
        var load = layer.load();
        var form = $("#commentForm").serialize();
        form += "&comment=" + encodeURIComponent($('.w-e-text').html());

        var arr = new Array();
        $.each($('.w-e-text .at-u'), function (index, value) {
          arr[index] = $(this).attr('data-id');
        });
        if (arr) {
          form += "&at=" + JSON.stringify(arr);
        }

        $.ajax({
          type: 'post',
          url: '/admin/chapterComment',
          dataType: 'json',
          data: form,
          success: function (data) {
            layer.close(load);
            if (data.code == 1) {
              layer.msg('评论成功!', { icon: 1 });
              addcomment(1, 0, data.content, data.data_id);
              initComment();
            } else if (data.code == -1) {
              layer.msg(data.msg, { icon: 2 });
            } else {
              layer.msg('评论失败!', { icon: 2 });
            }
          },
          error: function (data) {
            layer.close(load);
            if (data.code == 1) {
              layer.msg('评论成功!', { icon: 1 });
              addcomment(1, 0, data.content, data.data_id);
              initComment();
            } else if (data.code == -1) {
              layer.msg(data.msg, { icon: 2 });
            } else {
              if (data.responseJSON.message) {
                layer.msg(data.responseJSON.message, { icon: 2 });
              } else {
                layer.msg('网络错误，稍后重试!', { icon: 2 });
              }
            }
          }
        })
        layer.close(index);
      }
    });
  });


  $(document).on('click', '.del_comment,.del_reply', function () {
    var id = $(this).attr('data-id');
    var delthis = $(this);
    layer.confirm('确定要删除吗?', { icon: 3, title: '删除留言' }, function (index) {
      var load = layer.load(1);
      var page = $('.page').val();
      $.ajax({
        type: 'post',
        url: '/admin/deleteChapterComment',
        dataType: 'json',
        data: { 'id': id, 'page': page },
        success: function (data) {
          layer.close(load);
          if (data.code == 1) {
            layer.msg('删除成功!', { icon: 1 });
            if (delthis.attr('class') == 'del_comment') {
              delthis.parent().parent().parent().prev().remove();
            }
            delthis.parent().parent().parent().remove();
            init_time();
            initOverFlow();
          } else if (data.code == -1) {
            layer.msg(data.msg, { icon: 2 });
          } else {
            layer.msg('删除失败!', { icon: 2 });
          }
        },
        error: function (data) {
          layer.close(load);
          if (data.code == 1) {
            layer.msg('删除成功!', { icon: 1 });
            if (delthis.attr('class') == 'del_comment') {
              delthis.parent().parent().parent().prev().remove();
            }
            delthis.parent().parent().parent().remove();
            init_time();
            initOverFlow();
          } else if (data.code == -1) {
            layer.msg(data.msg, { icon: 2 });
          } else {
            if (data.responseJSON.message) {
              layer.msg(data.responseJSON.message, { icon: 2 });
            } else {
              layer.msg('网络错误，稍后重试!', { icon: 2 });
            }
          }
        }
      })
      layer.close(index);
    });

  });


  $('body').on('click', '.to-read', function () {
    var cid = $(this).attr("data-id");
    var cost = $(this).attr("data-cost");
    var payed = $(this).attr("data-payed");
    var user_id = $(this).attr("data-uid");
    var my_id = $(".user_id").val();
    var that = $(this);

    if (cost > 0 && payed == 0 && user_id != my_id) {
      layer.confirm('确定要支付' + cost + '金币吗?', { icon: 3, title: '金币支付' }, function (index) {
        $.ajax({
          type: 'post',
          url: '/admin/pay',
          dataType: 'json',
          data: { 'type': 2, 'object_id': cid, 'cost': cost },
          success: function (data) {
            if (data.code == 1) {
              that.attr("data-payed", 1);
              layer.open({
                title: '积分支付',
                content: data.msg,
                yes: function (index, layero) {
                  window.location.href = "/admin/novelReading?cid=" + cid;
                  layer.close(index);
                }
              });
            } else {
              layer.msg(data.msg, { icon: 2 });
            }
          },
          error: function (data) {
            layer.close(load);
            if (data.code == 1) {
              layer.msg(data.msg, { icon: 1 });
            } else if (data.code == -1) {
              layer.msg(data.msg, { icon: 2 });
            } else {
              if (data.responseJSON.message) {
                layer.msg(data.responseJSON.message, { icon: 2 });
              } else {
                layer.msg('网络错误，稍后重试!', { icon: 2 });
              }
            }
          }
        })
      });
    } else {
      window.location.href = "/admin/novelReading?cid=" + cid;
      return false;
    }
  })



  $('body').on('click', '.pay', function () {
    var cid = $(this).attr("data-id");
    var cost = $(this).attr("data-cost");
    var that = $(this);


    layer.confirm('确定要支付' + cost + '金币吗?', { icon: 3, title: '金币支付' }, function (index) {
      $.ajax({
        type: 'post',
        url: '/admin/pay',
        dataType: 'json',
        data: { 'type': 2, 'object_id': cid, 'cost': cost },
        success: function (data) {
          if (data.code == 1) {
            that.attr("data-payed", 1);
            layer.open({
              title: '积分支付',
              content: data.msg,
              yes: function (index, layero) {
                window.location.href = "/admin/novelReading?cid=" + cid;
                layer.close(index);
              }
            });
          } else {
            layer.msg(data.msg, { icon: 2 });
          }
        },
        error: function (data) {
          layer.close(load);
          if (data.code == 1) {
            layer.msg(data.msg, { icon: 1 });
          } else if (data.code == -1) {
            layer.msg(data.msg, { icon: 2 });
          } else {
            layer.msg('网络错误，稍后重试!', { icon: 2 });
          }
        }
      })
    });

  })

  // 使用计时器实现防抖函数
  function debounce(fun, delay = 500) {
    return function (...args) {
      let that = this
      let _args = args
      clearTimeout(fun.id)
      fun.id = setTimeout(function () {
        fun.call(that, ..._args)
      }, delay)
    }
  }
  document.addEventListener('keydown', debounce(function (event) {
    if ($(event.target).hasClass('w-e-text')) {
      return;
    }

    if (['textarea', 'input'].indexOf(event.target.type) >= 0) {
      return;
    }

    if (event.key === 'ArrowRight') {
      $('.next')[0].firstChild.click();
    } else if (event.key === 'ArrowLeft') {
      $('.last')[0].firstChild.click();
    }
  }))
});



// For Scroll on Click/ Swipe
function init_scroll_control() {
  if (/Mobi/.test(navigator.userAgent)) {
    scroll_switch = document.getElementsByTagName('meta')['scroll_switch_mobile'].content || 1;
  } else {
    scroll_switch = document.getElementsByTagName('meta')['scroll_switch_desktop'].content || false;
    if (scroll_switch == "0") { scroll_switch = false }
    else { scroll_switch = true }
  }

  if (scroll_switch) {
    var line_height = parseInt(document.querySelector("div.box").style.lineHeight.replace("px", ""))

    function scroll_up() {
      window.scrollBy({
        top: -window.innerHeight + line_height,
        behavior: "smooth"
      });
    }

    function scroll_down() {
      window.scrollBy({
        top: window.innerHeight - line_height,
        behavior: "smooth"
      });
      $("#novel-header").css("height", "0px");
    }

    function interact_setting() {
      if ($("#novel-header").height()) { $("#novel-header").css("height", "0px"); }
      else { $("#novel-header").css("height", "40px"); }
    }
    if (scroll_switch === true || scroll_switch === "1" || scroll_switch === "3") {
      $(".nvl-content").click(function (e) {
        //break if user is trying to select text
        if (getSelection().toString() !== "") { return }

        var divWidth = $("#app").width();
        console.log(e)
        var clickX = e.clientX;
        var clickY = e.clientY;

        if (clickX > divWidth / 3 * 2) {
          // right
          scroll_down()
        } else if (clickX < divWidth / 3) {
          // left
          scroll_up()
        } else if (clickY > window.innerHeight * 2 / 3) {
          // bottom center
          scroll_down()
        } else if (clickY < window.innerHeight / 3) {
          // top center
          scroll_up()
        } else {
          // center
          interact_setting()
        }
      });
    }

    //  swipe support:
    if (scroll_switch >= 2) {
      class Swipe {
        constructor(element) {
          this.xDown = null;
          this.yDown = null;
          this.element = typeof (element) === 'string' ? document.querySelector(element) : element;

          this.element.addEventListener('touchstart', function (evt) {
            this.xDown = evt.touches[0].clientX;
            this.yDown = evt.touches[0].clientY;
          }.bind(this), false);

        }

        onLeft(callback) {
          this.onLeft = callback;

          return this;
        }

        onRight(callback) {
          this.onRight = callback;

          return this;
        }

        onUp(callback) {
          this.onUp = callback;

          return this;
        }

        onDown(callback) {
          this.onDown = callback;

          return this;
        }

        handleTouchMove(evt) {
          if (!this.xDown || !this.yDown) {
            return;
          }

          var xUp = evt.touches[0].clientX;
          var yUp = evt.touches[0].clientY;

          this.xDiff = this.xDown - xUp;
          this.yDiff = this.yDown - yUp;


          // ignore if the travel is less than 30px
          if (Math.max(Math.abs(this.yDiff), Math.abs(this.xDiff)) < 30) { return; }

          if (Math.abs(this.xDiff) > Math.abs(this.yDiff)) { // Most significant.
            if (this.xDiff > 0) {
              this.onLeft();
            } else {
              this.onRight();
            }
          } else {
            if (this.yDiff > 0) {
              this.onUp();
            } else {
              this.onDown();
            }
          }

          // Reset values.
          this.xDown = null;
          this.yDown = null;
        }

        run() {
          this.element.addEventListener('touchmove', function (evt) {
            this.handleTouchMove(evt);
          }.bind(this), false);
        }
      }

      var swiper = new Swipe('.nvl-content');
      swiper.onLeft(function () { scroll_down() });
      swiper.onRight(function () { scroll_up() });
      swiper.onDown(function () { });
      swiper.onUp(function () { });
      swiper.run();
    }
  }
  $(".nvl-content a").click(function (e) {
    event.stopPropagation();
  })
}

function nScroll() {
  let chapter = $(".chapter-nav")[0],
    bookMark = chapter.getElementsByClassName("marked")[0];
  chapter.scrollTop = bookMark.offsetTop - bookMark.offsetHeight - 500;
}

$(window).load(init_scroll_control(), nScroll())


const ae_footnote_init = function () {

  const styles = `
.ae_noteref{
cursor: pointer;
color: #ddab14;
position: relative;
}
.ae_notecontent{
opacity: 0;
visibility: hidden;
transition: opacity, 0.3s;
z-index: 1;
background: white;
position: absolute;
padding: 0.3em;
border-radius: 0.3em;
box-shadow: 0 0 20px #555555;
text-indent: 0;
display: block;
max-width: 90vw;
width: 15em;
margin-right: 0%;
margin-left: auto;
}

.ae_notecontent[data-active]
{opacity:1;visibility: visible;}

.ae_noteref:after{
opacity: 0;
visibility: hidden;
transition: opacity, 0.3s;
content: "▲";
color: white;
font-size: 20px;
position: absolute;
right: calc(50% - 10px);
top: 10px;
z-index: 2;
}

.ae_noteref[data-active]:after
{opacity:1;visibility: visible;}

.ae_footnotesWarp{
border-top: 1px solid black;
font-size: 0.7em;
padding-top: 0.5em;
text-indent: -1em;
margin-left: 1em;
padding-left: 1em;
padding-right: 1em;
}

.ae_footnote_arrow{
color: blue;
border: none;
background: inherit;
width: 1.5em;
}
`;

  const novelBody = document.querySelector(".nvl-content").children[0];//.nvl-content有手机版滚轮事件
  const refs = document.getElementsByClassName("ae_noteref");
  const contents = document.getElementsByClassName("ae_notecontent");
  if (refs.length == 0) { return; }
  if (refs.length != contents.length) { console.log(`[AE牌注释] 引用数量（${refs.length}）与内容数量（${contents.length}）不符！`); return; }
  const footnotesWarp = document.createElement("div");
  footnotesWarp.className = "ae_footnotesWarp";
  novelBody.appendChild(footnotesWarp);
  const styleSheet = document.createElement("style");
  styleSheet.type = "text/css";
  styleSheet.innerText = styles;
  document.head.appendChild(styleSheet);
  for (let i = 0; i < refs.length; i++) {
    const content = contents[i];
    content.onclick = (event) => { event.stopPropagation(); };
    refs[i].onclick = (event) => {
      content.setAttribute("data-active", "active");
      refs[i].setAttribute("data-active", "active");
      if (refs[i].offsetLeft + content.offsetWidth + 10 > novelBody.offsetLeft + novelBody.offsetWidth) {
        content.style.left = novelBody.offsetLeft + novelBody.offsetWidth - content.offsetWidth + "px";
      } else if (refs[i].offsetLeft - 30 < novelBody.offsetLeft) {
        content.style.left = refs[i].offsetLeft + "px";
      } else {
        content.style.left = refs[i].offsetLeft - 30 + "px";
      }
      content.style.top = refs[i].offsetTop + 30 + "px";

      event.stopPropagation();
    }
    const footnote = document.createElement("div");
    footnote.innerHTML = "<button class='ae_footnote_arrow'>＾</button>" + content.innerHTML;
    footnotesWarp.appendChild(footnote);
    footnote.getElementsByClassName("ae_footnote_arrow")[0].onclick = (event) => {
      content.scrollIntoView({ behavior: "smooth", block: "center", inline: "nearest" });
      setTimeout(() => { refs[i].click(); }, 500);
      event.stopPropagation();
    }

  }
  novelBody.onclick = function (event) {
    [].forEach.call(contents, (e) => {
      if (e.getAttribute("data-active")) { e.removeAttribute("data-active"); event.stopPropagation(); }
    });
    [].forEach.call(refs, (e) => {
      if (e.getAttribute("data-active")) { e.removeAttribute("data-active"); }
    });
  }

}
window.addEventListener("load", ae_footnote_init); //等vue加载后

