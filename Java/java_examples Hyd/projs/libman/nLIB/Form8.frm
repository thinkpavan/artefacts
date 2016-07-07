VERSION 5.00
Object = "{67397AA1-7FB1-11D0-B148-00A0C922E820}#6.0#0"; "MSADODC.OCX"
Begin VB.Form frmProfessorIssue 
   BackColor       =   &H00400040&
   Caption         =   "Professor Issue Details"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   Picture         =   "Form8.frx":0000
   ScaleHeight     =   3195
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   WindowState     =   2  'Maximized
   Begin VB.CommandButton cmdView 
      BackColor       =   &H00E0E0E0&
      Caption         =   "&View"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   435
      Left            =   7470
      Style           =   1  'Graphical
      TabIndex        =   5
      Top             =   4185
      Width           =   810
   End
   Begin VB.TextBox txtBookid 
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   480
      Left            =   6000
      TabIndex        =   4
      Top             =   4185
      Width           =   1350
   End
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
      Height          =   495
      Left            =   7170
      Style           =   1  'Graphical
      TabIndex        =   16
      Top             =   6795
      Width           =   1215
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
      Height          =   495
      Left            =   5625
      Style           =   1  'Graphical
      TabIndex        =   6
      Top             =   6795
      Width           =   1215
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
      Height          =   495
      Left            =   4095
      Style           =   1  'Graphical
      TabIndex        =   1
      Top             =   6795
      Width           =   1215
   End
   Begin VB.TextBox Text1 
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6000
      TabIndex        =   2
      Top             =   2985
      Width           =   2295
   End
   Begin MSAdodcLib.Adodc Adodc1 
      Height          =   375
      Left            =   360
      Top             =   2520
      Width           =   1575
      _ExtentX        =   2778
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
      RecordSource    =   "professorissue"
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
   Begin VB.TextBox txtDepartment 
      DataField       =   "Department"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6000
      TabIndex        =   3
      Top             =   3600
      Width           =   2295
   End
   Begin VB.Label Label7 
      BackStyle       =   0  'Transparent
      Caption         =   "Issue Date"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   3975
      TabIndex        =   15
      Top             =   5880
      Width           =   1935
   End
   Begin VB.Label Label6 
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
      Height          =   495
      Left            =   3960
      TabIndex        =   14
      Top             =   5280
      Width           =   1935
   End
   Begin VB.Label Label5 
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
      Height          =   495
      Left            =   3960
      TabIndex        =   13
      Top             =   4680
      Width           =   1935
   End
   Begin VB.Label Label4 
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
      TabIndex        =   12
      Top             =   4200
      Width           =   1935
   End
   Begin VB.Label Label3 
      BackStyle       =   0  'Transparent
      Caption         =   "Department"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   3960
      TabIndex        =   11
      Top             =   3600
      Width           =   1935
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Professor Name"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   3960
      TabIndex        =   10
      Top             =   3000
      Width           =   1935
   End
   Begin VB.Label lblIssuedate 
      BackColor       =   &H8000000E&
      DataField       =   "IssueDate"
      DataSource      =   "Adodc1"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6000
      TabIndex        =   9
      Top             =   5925
      Width           =   1695
   End
   Begin VB.Label lblAuthorname 
      BackColor       =   &H8000000E&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6000
      TabIndex        =   8
      Top             =   5325
      Width           =   3015
   End
   Begin VB.Label lblBooktitle 
      BackColor       =   &H8000000E&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   6000
      TabIndex        =   7
      Top             =   4725
      Width           =   3015
   End
   Begin VB.Label lblSearch 
      AutoSize        =   -1  'True
      BackColor       =   &H00C0E0FF&
      BackStyle       =   0  'Transparent
      Caption         =   "Professor's Issue Detail Form"
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
      Index           =   2
      Left            =   3240
      TabIndex        =   0
      Top             =   1920
      Width           =   6300
   End
End
Attribute VB_Name = "frmProfessorIssue"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit
Public con As ADODB.Connection
Public rec1 As ADODB.Recordset


Private Sub cmdView_Click()
If txtBookid.Text = "" Then
MsgBox "Insert Book Id", vbInformation, " Data Required"
Exit Sub
End If

If rec1.State Then
rec1.Close
End If

rec1.Open "select * from bookdetails where bookid=" & Me.txtBookid.Text & " ", con, adOpenDynamic, adLockOptimistic

If rec1.EOF = False Then
    Me.lblBooktitle.Caption = rec1!booktitle
    Me.lblAuthorname.Caption = rec1!authorname

        If rec1.Fields(5).Value = 0 Then
            MsgBox "Books are not available"
            Me.cmdSave.Enabled = False
            Me.cmdAdd.Enabled = True
        End If

    rec1.Close
    Me.lblIssuedate.Caption = Format(Now, ("dd-mmm-yyyy"))
    
End If

End Sub

Private Sub cmbBookid_KeyPress(KeyAscii As Integer)
KeyAscii = 0
End Sub

Private Sub Form_Load()
Me.cmdSave.Enabled = False
Me.Adodc1.Visible = False


Set con = New ADODB.Connection
con.ConnectionString = " Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\WINDOWS\Desktop\nLIB\db1.mdb;Persist Security Info=False "
con.Open
Set rec1 = New ADODB.Recordset
'If rec1.State Then rec1.Close
'rec1.Open "select bookid from bookdetails", con, adOpenDynamic, adLockOptimistic
'If rec1.EOF = False Then
'    While Not rec1.EOF
        'cmbBookid.AddItem rec1!bookid
        'rec1.MoveNext
'    Wend
'    rec1.MoveFirst
'    cmbBookid.Text = rec1!bookid
'    rec1.Close
'End If
End Sub

Private Sub cmdAdd_Click()
Me.Adodc1.Recordset.AddNew
Me.cmdAdd.Enabled = False
Me.cmdSave.Enabled = True
End Sub

Private Sub cmdBack_Click()
Unload Me
frmMain.Show
End Sub

Private Sub cmdSave_Click()
Me.Adodc1.Recordset.Update
Me.cmdSave.Enabled = False
Me.cmdAdd.Enabled = True

Dim temp As Integer
If rec1.State Then
rec1.Close
End If
rec1.Open "select * from bookdetails where bookid=" & Me.txtBookid.Text & " ", con, adOpenDynamic, adLockOptimistic
If rec1.Fields(5).Value = 1 Then
MsgBox "It was last copy"
End If

temp = rec1.Fields(5).Value - 1
con.Execute "update bookdetails set noofcopies=" & temp & " where bookid=" & Me.txtBookid.Text & " "

End Sub


Private Sub Text1_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ'"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
End Sub

Private Sub txtDepartment_KeyPress(KeyAscii As Integer)
Dim STRVALID As String
STRVALID = "ABCDEFGHIJKLMNOPQRSTUVWXYZ'"
KeyAscii = Asc(UCase(Chr(KeyAscii)))
If KeyAscii > 26 Then
    If InStr(STRVALID, Chr(KeyAscii)) = 0 Then
        KeyAscii = 0
    End If
End If
End Sub
