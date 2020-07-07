<html>
    <head>
        <meta charset="utf-8">
        <title>卖家商品列表</title>
        <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>订单id</th>
                        <th>姓名</th>
                        <th>手机号</th>
                        <th>地址</th>
                        <th>金额</th>
                        <th>订单状态</th>
                        <th>支付状态</th>
                        <th>创建时间</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list orderDTOPage.content as orderDTO>
                    <tr>
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.buyerName}</td>
                        <td>${orderDTO.buyerPhone}</td>
                        <td>${orderDTO.buyerAddress}</td>
                        <td>${orderDTO.orderAmount}</td>
                        <td>${orderDTO.getOrderStatusEnum().getMsg()}</td>
                        <td>${orderDTO.getPayStatusEnum().getMsg()}</td>
                        <td>${orderDTO.createTime}</td>
                        <td>详情</td>
                        <td>取消</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>

<#--        分页-->
        <div class="col-md-12 column">
            <ul class="pagination pull-right">
                <#if currentPage lte 1>

                </#if>
                <li>
                    <a href="#">上一页</a>
                </li>

                <#list 1..orderDTOPage.getTotalPages() as index>
                    <#if currentPage == index>
                        <li class="disabled">
                            <a href="#">${index}</a>
                        </li>
                    <#else>
                        <li><a href="?page=${index}&size=5">${index}</a></li>
                    </#if>
                </#list>

                <li>
                    <a href="#">下一页</a>
                </li>
            </ul>
        </div>
    </div>
    </body>
</html>