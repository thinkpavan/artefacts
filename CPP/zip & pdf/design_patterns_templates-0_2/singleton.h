#ifndef TEMPLATE_PATTERNS_SINGLETON
#define TEMPLATE_PATTERNS_SINGLETON

/// Templated design pattern implementation for C++ version 0.2
/** (C) 2006 - Rasmus Christian Kaae, http://www.hestebasen.com/kaae/code.xml */
namespace template_patterns
{
  /// Singleton template class
  /** The singleton creates a singleton instance from a given class, T, and allows
  it to be reached globally and uniquely within the application. Say you have class C and want to turn it into a singleton,
  simply add the following code: <i>typedef singleton<C> c_singleton;</i>. Whenever you need to hook up with the singleton
  just write <i>c_singleton.instance().my_function(params);</i>.
  \param T class to allow singleton behaviour
  */
  template <class T> class singleton
  {
  public:
    /// Retrieve the instance
    /** \return the instance of type T
    */
    T & instance()
    {
      static T object;
      return object;
    }

    /// Retrieve the instance.
    /** \sa instance
        \return the instance of type T
    */
    T & operator* ()
    {
      return instance();
    }

    /// Retrieve the const instance.
    /** \sa instance
    \return the const instance of type T
    */
    const & operator* () const
    {
      return &instance();
    }
  };


};


#endif // TEMPLATE_PATTERNS_SINGLETON
