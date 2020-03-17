<ul <#if id?exists>id="${id}"</#if> class="nav nav-list" style="top: 0px;">
    <!-- 递归  宏定义 -->
    <#macro bpTree children>
        <#if children?? && children?size gt 0>
            <#list children as child>
                <#if child.children?? && child.children?size gt 0>
                    <li>
                    <a href="javascript:void(0)" class="dropdown-toggle">
                    <i class="menu-icon fa <#if child.image?exists>${child.image}</#if>"></i>
                    <span class="menu-text"> ${child.name} </span>
                <b class="arrow fa fa-angle-down"></b>
                    </a>
                <b class="arrow"></b>
                    <ul class="submenu">
                    <@bpTree children=child.children />
                    </ul>
                    </li>
                <#else>
                    <li class="">
                <#--<#if child.url != "">-->
                <#--<a href="${contextPath}/${child.url}">-->
                <#--<i class="menu-icon fa fa-caret-right"></i>-->
                <#--${child.name}-->
                <#--</a>-->
                <#--<#else>-->
                    <#if child.url != "">
                        <a href="javascript:void(0)" data-url="${contextPath}/${child.url}">
                    <i class="menu-icon fa <#if child.image?exists>${child.image}</#if>"></i>
                        ${child.name}
                        </a>
                    <#else>
                        <a href="javascript:void(0)">
                        <i class="menu-icon fa <#if child.image?exists>${child.image}</#if>"></i>
                        ${child.name}
                        </a>
                    </#if>
                    <b class="arrow"></b>
                    </li>
                </#if>
            </#list>
        </#if>
    </#macro>
        <!-- 调用宏 生成递归树 -->
    <@bpTree children=treeMenu />
</ul>