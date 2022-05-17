<#import "commons.ftlh" as c>

<@c.page>
    <#if currUser??>
        <div>
            <ul>
                <li>
                    "id":${currUser.id}
                </li>
                <li>
                    "login":${currUser.login}
                </li>
                <li>
                    "creation time":${currUser.creationTime}
                </li>
            </ul>
        </div>
    <#else>
        No such user
    </#if>
</@c.page>