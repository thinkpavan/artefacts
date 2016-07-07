A filter is an object that can transform the header and
 content (or both) of a request or response.

Applications of filters include authentication, logging,
 image conversion, data compression, encryption etc.

Filter,FilterChain and FilterConfig are defined as part of
javax.servlet package.

We need to implement doFilter which receives request,response and
FilterChain object as inputs.

init and destroy methods will be called when filter is initialized and
destroyed.
