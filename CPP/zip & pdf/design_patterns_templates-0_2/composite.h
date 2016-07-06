#ifndef TEMPLATE_PATTERNS_COMPOSITE
#define TEMPLATE_PATTERNS_COMPOSITE

/// Templated design pattern implementation for C++ version 0.2
/** (C) 2006 - Rasmus Christian Kaae, http://www.hestebasen.com/kaae/code.xml */
namespace template_patterns
{
  /// Composite template class
  /** The composite design pattern allows a client object to treat both single components and collections of components identically.
  All entities must implement the <i>void execute(type_name &parent)</i> function, which is called recursively through the composite tree.

  \param T class to allow composite behaviour
  */
  template <class T> class composite : public T
  {
  private:
    std::vector< composite<T> >  items;         ///< Vector of sub-items of this node
  protected:
    /// Recursively execute all items
    /** Executes all items in the composite element recursively.
    \param parent reference to the caller
    \sa perform, items
    */
    void sub_execute(T &parent)
    {
      execute(parent);
      for (std::vector< composite<T> >::iterator i=items.begin(); i!=items.end(); ++i)
      {
        i->sub_execute(*this);
      }
    }
  public:
    /// Add a new item to the vector of sub-items of this node
    /** \sa perform */
    void add(composite<T> &item)
    {
      items.push_back(item);
    }

    /// Perform the composition, i.e. execute all sub-items recursively.
    /** \sa add, sub_execute */
    void perform()
    {
      sub_execute(*this);
    }

  };


};


#endif // TEMPLATE_PATTERNS_SINGLETON
