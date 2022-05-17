<#import "commons.ftlh" as c>

<@c.page>
    <div class="users datatable">
        <div class="caption">User</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Created</th>
            </tr>
            </thead>
            <tbody>
            <#if users?size==0>
                <tr class="noData">
                    <td colspan="3">
                        No data
                    </td>
                </tr>
            <#else>
                <#list users as user>
                    <tr>
                        <td class="id">${user.id}</td>
                        <td class="login"><a href="/user/${user.id}">${user.login}</a></td>
                        <td class="creationTime">${user.creationTime}</td>
                        <td class="status">
                            <form method="post">
                                <input type="hidden" name="userId" value="${user.id}">
                                <#if user.disabled>
                                    <#assign val = "Enable">
                                <#else>
                                    <#assign val = "Disable">
                                </#if>
                                <input type="hidden" name="status" value="${val}">
                                <input type="submit" value="${val}">
                            </form>
                        </td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@c.page>
