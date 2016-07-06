#ifndef TEMPLATE_PATTERNS_FACTORY
#define TEMPLATE_PATTERNS_FACTORY

/// Templated design pattern implementation for C++ version 0.2
/** (C) 2006 - Rasmus Christian Kaae, http://www.hestebasen.com/kaae/code.xml */
namespace template_patterns
{
  /// Factory template class
  /** The factory design pattern allows for easily replacement of implementation of classes. It facilitate a central
  repository where all dependencies are bound to the interface of the base class. The template factory is created using
  a simple definition: <i>typedef factory<C,B> c_factory;</i>. New instances implementing the C interface can be build using
  the <i>c_factory::create()</i> function, where B is a class implementing the C interface.

  The template factory does not handle resource management, however it would be a good idea to manage the allocated instances
  with smart pointers, e.g. <i>boost::scoped_ptr<C> my_c_pointer(c_factory::create());</i>.
  \sa factory_with_initializer

  \param T class type of the return value
  \param I actual implementation class, a derivate of T
  */
  template <class T, class I> class factory
  {
  public:
    /// Create new instance.
    /** Create a new, unmananged, instance of T.
        \return a new instance of T
    */
    static T * create()
    {
      return static_cast<T*>(new I());
    }
  };

  /// Factoy template class with object initializer
  /** Template class for building factories that initialize their objects before returning them to the user. This is an
  extension to the ordinary template for factory. The initializer, paramter F, is a function class meaning that it's a class or struct
  that overloads the operator() function. \sa factory

  \param T class type of the return value
  \param I actual implementation class, a derivate of T
  \param F function class for initializing the new instance of I before casting it to T and returning it to the user.
  */
  template <class T, class I, class F> class factory_with_initializer
  {
  public:
    /// Create new instance and initialize it before returning it to the user.
    /** Create a new, unmananged, instance of T, where T is a derivate of I. After initialization the initializer, function
    class F, is executed on the object.
        \return a new instance of T
    */
    static T * create()
    {
      return F()(static_cast<T*>(new I()));
    }
  };
};

#endif // TEMPLATE_PATTERNS_FACTORY
