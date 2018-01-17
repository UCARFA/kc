# CORE integration

The configuration settings to enable/disable Core Auth in the Kuali Research monolith. Most of the settings
are for a production environment, there are some that are intended for a development environment only.

## External Configuration settings

### auth.base.url
> Base url for the Core server
>
> **Syntax:** `<schema>://<host>:<port>`\
> **Default:** `https://${application.rest.services.base.url}`\
> **Example:** `http://localhost:3000`

### auth.core.enabled
>Enable/disable Core Auth for authentication
>
> **Valid Values:** true | false \
> **Default:** false

### auth.filter.allow.admin.proxy
> Enable/disable proxy login. When set to true if a Core Auth user with role
> of 'admin' logs into the research system, but that user does not exist in
> KIM the user configured below will be used instead
>
> **Valid Values:** true | false
> **Default:** false

### auth.filter.proxy.username
> Admin account to use for a proxy login. See the description for
> 'auth.filter.allow.admin.proxy' for more information.
>
> **Example:** admin

### auth.filter.service2service.enabled
> Enables service to service communication through Core Auth. When enabled,
> api requests that aren't associated with a specific user will be sent and
> authenticated using a shared secret instead of a user based api key. This
> secret must be the same as all other connected services (eg. Core and COI)
> When disabled all requests must be authenticated by a users auth token or
> api key(default) and the system will use the configured
> 'auth.system.token' instead.
>
> **Valid Values:** true | false \
> **Default:** false

### auth.filter.service2service.secret
> Shared secret for service to service communication through Core Auth.
>
> **Example:** secret

### auth.filter.service2service.singleUse
> When enabled service2service tokens are only valid for one service request
> and the system will keep track of previously used tokens and reject after
> being used the first time.
>
> **Valid Values:** true | false \
> **Default:** false

### auth.filter.service2service.username
> When service to service is enabled, all requests authenticated via a
> service to service will be proxied as this username in the research
> system. This user must exist in KIM. All
> authorization checks will be performed against this user via KIM.
> Ensure this user has all accesses required by remote systems. Recommended
> to use the admin user, but must be explicitly configured.
>
> **Example:** admin

### auth.rest.urls.regex
> comma separated list of valid auth urls that must be protected via api style security instead of traditional cookie based security. Only needs to
> be configured if apis are added to the system via code customizations.
>
> **default:** `.*/api/v1/.*,.*/api/v2/.*,.*/hr-import/hrimport/.*`

### auth.system.token
> Auth Token Generated in Core for an admin user. This is still required
> for some background requests when integrated with COI even when
> service2service is enabled.
>
> **Default:** <blank>

### auth.user.push.dev.password
> Password used for all users when `auth.user.push.use.dev.password` is set to true. Must be set prior to pushing users to Core.
>
> **Default:** password\
> **Dev Only**

### auth.user.push.use.dev.password
> Enable/Disable the use of dev passwords. If using the 'Push Users to the Core Auth Service'
> feature in the system, this flag determines whether the simple 'auth.user.push.dev.password' is used for ALL users or whether a random 32
> character alpha-numberic string is used for each individual user.
> Should only be set to true in development environments as the same
> password for all users presents an obvious security risk.
>
> **Valid Values:** true | false\
> **Default:** false

### auth.users.url
> Url for the User API for Core.
>
> **Example:** `http://localhost:3000/api/v1/users` \
> **Default:** ${auth.base.url}/api/v1/users

### core.categories.url
> Url for the Core categories api. Optional override to provide flexibility if the categories api is available in a non-standard location
>
> **Example:** `http://localhost:3000/api/v1/categories` \
> **Default:** ${auth.base.url}/api/v1/categories

### core.groups.url
> Url for the Core groups api. Optional override to provide flexibility if the groups api is available in a non-standard location
>
> **Example:** `http://localhost:3000/api/v1/groups` \
> **Default:** ${auth.base.url}/api/v1/groups


### filter.login.class 
> Class used by Kuali to process login requests. To use Core Auth as the login page use `org.kuali.coeus.sys.framework.auth.AuthServiceFilter`
> as the login class.

### rice.portal.logout.redirectUrl
> URL to log out of Kuali with.  Core Auth uses `http://localhost:3000/auth/signout` to log out of the
> system
