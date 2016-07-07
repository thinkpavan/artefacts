VERSION 5.00
Object = "{67397AA1-7FB1-11D0-B148-00A0C922E820}#6.0#0"; "MSADODC.OCX"
Begin VB.Form frmBookRecord 
   BackColor       =   &H00400040&
   Caption         =   "Book Records"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form6"
   Picture         =   "Form6.frx":0000
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   WindowState     =   2  'Maximized
   Begin VB.CommandButton cmdBack 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Back"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   465
      Left            =   8760
      Style           =   1  'Graphical
      TabIndex        =   18
      Top             =   6450
      Width           =   1185
   End
   Begin VB.CommandButton cmdDelete 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Delete"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   465
      Left            =   7440
      Style           =   1  'Graphical
      TabIndex        =   17
      Top             =   6450
      Width           =   1185
   End
   Begin VB.CommandButton cmdModify 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Modify"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   465
      Left            =   6120
      Style           =   1  'Graphical
      TabIndex        =   16
      Top             =   6450
      Width           =   1185
   End
   Begin VB.CommandButton cmdSearch 
      BackColor       =   &H00E0E0E0&
      Caption         =   "S&earch"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   465
      Left            =   4815
      Style           =   1  'Graphical
      TabIndex        =   15
      Top             =   6465
      Width           =   1185
   End
   Begin VB.CommandButton cmdSave 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Save"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   465
      Left            =   3495
      Style           =   1  'Graphical
      TabIndex        =   14
      Top             =   6465
      Width           =   1185
   End
   Begin VB.CommandButton cmdAdd 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&Add"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   15.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   465
      Left            =   2175
      Style           =   1  'Graphical
      TabIndex        =   13
      Top             =   6465
      Width           =   1185
   End
   Begin MSAdodcLib.Adodc Adodc1 
      Height          =   375
      Left            =   480
      Top             =   2160
      Width           =   1815
      _ExtentX        =   3201
      _ExtentY        =   661
      ConnectMode     =   0
      CursorLocation  =   3
      IsolationLevel  =   -1
      ConnectionTimeout=   15
      CommandTimeout  =   30
      CursorType      =   3
      LockType        =   3
      CommandType     =   2
      CursorOptions   =   0
      CacheSize       =   50
      MaxRecords      =   0
      BOFAction       =   0
      EOFAction       =   0
      ConnectStringType=   1
      Appearance      =   1
      BackColor       =   -2147483643
      ForeColor       =   -2147483640
      Orientation     =   0
      Enabled         =   -1
      Connect         =   "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False"
      OLEDBString     =   "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False"
      OLEDBFile       =   ""
      DataSourceName  =   ""
      OtherAttributes =   ""
      UserName        =   ""
      Password        =   ""
      RecordSource    =   "bookdetails"
      Caption         =   "Adodc1"
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      _Version        =   393216
   End
   Begin VB.TextBox txtNoofcopies 
      DataField       =   "Noofcopies"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   420
      Left            =   5880
      MaxLength       =   3
      TabIndex        =   4
      Tag             =   "no of copies"
      Top             =   5520
      Width           =   1575
   End
   Begin VB.TextBox txtBookid 
      DataField       =   "BookId"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   420
      Left            =   5880
      TabIndex        =   5
      Tag             =   "book id"
      Top             =   3120
      Width           =   1575
   End
   Begin VB.TextBox txtBooktitle 
      DataField       =   "BookTitle"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   420
      Left            =   5880
      MaxLength       =   28
      TabIndex        =   0
      Tag             =   "book name"
      Top             =   3600
      Width           =   2655
   End
   Begin VB.TextBox txtAuthorname 
      DataField       =   "AuthorName"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   420
      Left            =   5880
      MaxLength       =   25
      TabIndex        =   1
      Tag             =   "author name"
      Top             =   4080
      Width           =   2655
   End
   Begin VB.TextBox txtPublisher 
      DataField       =   "Publisher"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   420
      Left            =   5880
      MaxLength       =   15
      TabIndex        =   2
      Tag             =   "publiisher"
      Top             =   4560
      Width           =   2655
   End
   Begin VB.TextBox txtPrice 
      DataField       =   "Price"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   420
      Left            =   5880
      MaxLength       =   6
      TabIndex        =   3
      Tag             =   "price"
      Top             =   5040
      Width           =   1575
   End
   Begin VB.Label lblSearch 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0E0FF&
      BackStyle       =   0  'Transparent
      Caption         =   "Book Record Form"
      BeginProperty Font 
         Name            =   "Century Gothic"
         Size            =   24
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00C0E0FF&
      Height          =   585
      Index           =   0
      Left            =   3915
      TabIndex        =   12
      Top             =   1920
      Width           =   4275
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "No. of copies"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   3960
      TabIndex        =   11
      Top             =   5520
      Width           =   1455
   End
   Begin VB.Label book_id 
      BackStyle       =   0  'Transparent
      Caption         =   "Book Id"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   3960
      TabIndex        =   10
      Top             =   3120
      Width           =   1455
   End
   Begin VB.Label Book_name 
      BackStyle       =   0  'Transparent
      Caption         =   "Book Title"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   3960
      TabIndex        =   9
      Top             =   3600
      Width           =   1455
   End
   Begin VB.Label author_name 
      BackStyle       =   0  'Transparent
      Caption         =   "Author Name"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   3960
      TabIndex        =   8
      Top             =   4080
      Width           =   1455
   End
   Begin VB.Label publisher 
      BackStyle       =   0  'Transparent
      Caption         =   "Publisher"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   3960
      TabIndex        =   7
      Top             =   4560
      Width           =   1455
   End
   Begin VB.Label price 
      BackStyle       =   0  'Transparent
      Caption         =   "Price"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   375
      Left            =   3960
      TabIndex        =   6
      Top             =   5040
      Width           =   1455
   End
End
Attribute VB_Name = "frmBookRecord"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim cn As ADODB.Connection
Dim con As ADODB.Connection
Dim rec As ADODB.Recordset
Dim usql As String


Private Sub Form_Load()
Set cn = New ADODB.Connection
cn.Open "Provider=Microsoft.Jet.OLEDB.4.0;Persist Security Info=False;Data Source=\windows\desktop\nLIB\db1.mdb"
Set rec = New ADODB.Recordset
Set rec.ActiveConnection = cn
Me.Adodc1.Visible = False
cmdSave.Enabled = False
End Sub

Private Sub cmdAdd_Click()
Me.Adodc1.Recordset.AddNew


Me.txtBooktitle.SetFocus
    If rec.State Then rec.Close
        rec.Open "select bookid from bookdetails"
        If rec.EOF And rec.BOF Then
           txtBookid.Text = 100
        Else
        If rec.State Then rec.Close
            rec.Open "select max(bookid) from bookdetails"
            txtBookid.Text = rec.Fields(0).Value + 1
    End If

cmdAdd.Enabled = False
cmdSave.Enabled = True
End Sub

Private Sub cmdBack_Click()
Unload Me
frmMain.Show
End Sub




Private Sub cmdDelete_Click()
If Me.txtBooktitle.Text = "" Or Me.txtAuthorname.Text = "" Or Me.txtPublisher.Text = "" Or Me.txtPrice.Text = "" Or Me.txtNoofcopies.Text = "" Then
MsgBox ("No record is present")
Exit Sub
Else
cn.Execute "delete from bookdetails where bookid = " & txtBookid.Text & ""
MsgBox "Record Deleted"
End If
Adodc1.Refresh
End Sub

Private Sub cmdModify_Click()
If Me.txtBooktitle.Text = "" Or Me.txtAuthorname.Text = "" Or Me.txtPublisher.Text = "" Or Me.txtPrice.Text = "" Or Me.txtNoofcopies.Text = "" Then
MsgBox ("No record is present")
Exit Sub
Else
cn.Execute "update bookdetails set booktitle = '" & Me.txtBooktitle.Text & "', authorname='" & Me.txtAuthorname.Text & "', publisher='" & Me.txtPublisher.Text & "',price=" & Me.txtPrice.Text & ",noofcopies=" & Me.txtNoofcopies.Text & " where bookid = " & Me.txtBookid.Text & ""
MsgBox "Record Updated"
End If
Me.Adodc1.Refresh
End Sub

Private Sub cmdSave_Click()
If Me.txtBooktitle.Text = "" Or Me.txtAuthorname.Text = "" Or Me.txtPublisher.Text = "" Or Me.txtPrice.Text = "" Or Me.txtNoofcopies.Text = "" Then
MsgBox "Incomplete Record", vbInformation, "Enter Book Record"
Exit Sub
Else
Me.Adodc1.Recordset.Update
MsgBox ("Record Saved")
'cn.Execute "insert into bookdetails values(" & txtBookid.Text & ",'" & txtBooktitle.Text & "','" & Me.txtAuthorname.Text & "','" & Me.txtPublisher.Text & "'," & Me.txtPrice.Text & "," & Me.txtNoofcopies.Text & ")"
End If
cmdSave.Enabled = False
cmdAdd.Enabled = True
End Sub

Private Sub cmdSearch_Click()
Set rec = New ADODB.Recordset
Dim ans As String
ans = InputBox("Enter the book name")
rec.Open "select * from bookdetails", cn, adOpenDynamic
rec.Find "booktitle='" & ans & "'"
If ans = "" Then
Exit Sub
End If
On Error GoTo message
If ans <> "" Then
Me.txtBookid.Text = rec.Fields(0)
Me.txtBooktitle.Text = rec.Fields(1)
Me.txtAuthorname.Text = rec.Fields(2)
Me.txtPublisher.Text = rec.Fields(3)
Me.txtPrice.Text = rec.Fields(4)
Me.txtNoofcopies.Text = rec.Fields(5)
End If

message:
If Err Then
MsgBox "Record not found"
End If
End Sub



Private Sub txtAuthorname_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ' "
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
If KeyAscii = 13 Then
txtPublisher.SetFocus
End If
End Sub

Private Sub txtBookid_KeyPress(KeyAscii As Integer)
KeyAscii = 0
End Sub

Private Sub txtBooktitle_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ' "
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
If KeyAscii = 13 Then
txtAuthorname.SetFocus
End If
End Sub

Private Sub txtNoofcopies_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "0123456789"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
End Sub

Private Sub txtPrice_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "0123456789."
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
If KeyAscii = 13 Then
txtNoofcopies.SetFocus
End If
End Sub

Private Sub txtPublisher_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ' "
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
If KeyAscii = 13 Then
txtPrice.SetFocus
End If
End Sub
