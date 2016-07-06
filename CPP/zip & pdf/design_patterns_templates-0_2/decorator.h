#ifndef TEMPLATE_PATTERNS_DECORATOR
#define TEMPLATE_PATTERNS_DECORATOR

#include <vector>

/// Templated design pattern implementation for C++ version 0.2
/** (C) 2006 - Rasmus Christian Kaae, http://www.hestebasen.com/kaae/code.xml */
namespace template_patterns
{
  /// Decorator template class
  /** The decorator design pattern allows for easy application of series of operations to the same base instance.
  An example would be a GUI library where the base instance is the frame, adding scroll bars and task bar icons
  are handled using decorators. Using the decorator pattern the programmer enables the software to inline new frames
  within other frames, etc.
  \param T class to allow decorator behavior
  */
  template <class T> class decorator : public T
  {
  private:
    /// List of decorators prepared to decorate <i>this</i> instance
    std::vector<T>  decorators;
  public:
    /// Add a decorator to the list of decorators
    /** Pushes a decorator element to the internal list of decorators.
        \sa decorators, perform
        \param element reference to an element to add to the list.
    */
    void decorate(T &element)
    {
      decorators.push_back(element);
    }

    /// Perform the decoration of the base class with the added decorators
    /** Initially launches the execute function of the base class, with it self as parameter. Added decorator elements will be
    called in the same order as they were added. Additionally all calls to <i>execute</i> is fed with a reference to the base
    instance.
    */
    void perform()
    {
      execute(*this);
      for (std::vector<T>::iterator i=decorators.begin(); i!=decorators.end(); ++i)
      {
        i->execute(*this);
      }
    }

  };


};


#endif // TEMPLATE_PATTERNS_DECORATOR
